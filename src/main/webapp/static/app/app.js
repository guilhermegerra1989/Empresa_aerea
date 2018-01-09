Highcharts.setOptions({
    global: {
        useUTC: false
    }
});
angular.module('app', ['ngRoute', 'ngLocale', 'ngAnimate', 'i18n', 'ui.bootstrap', 'restangular', 'ui.bootstrap.position',
    'chieffancypants.loadingBar','angular-carousel','googlechart','highcharts-ng','ui.sortable','angularFileUpload'])
    .run(function ($rootScope, $location, $window, CurrentUser) {
        $rootScope.currentUser = CurrentUser;
        $rootScope.$on('$routeChangeSuccess', function () {
            $rootScope.pageClass = $location.path().split('/').join(' ').trim();
        });
        $rootScope.goBack = function () {
            $window.history.back();
        };

        $rootScope.baseUrl = baseUrl;
    });

angular.module('app').config(function (RestangularProvider) {
    RestangularProvider.setResponseExtractor(function (response, operation, what, url) {
        if (operation === "getList") {
            if (!response)
                return [];

            if (response.paginated) {
                var newResponse = response.items;
                newResponse.currentPage = response.currentPage;
                newResponse.itemsPerPage = response.itemsPerPage;
                newResponse.totalItems = response.totalItems;

                return newResponse;
            }
        }

        return response;
    });
});

angular.module('app').config(function ($provide, $httpProvider) {

    $httpProvider.interceptors.push(function ($q) {
        return {
            request: function(config) {
                config.url = baseUrl  + config.url;
                return config;
            },

            responseError: function (rejection) {
                if (rejection.status === 500) {
                    toastr.error("There was an error processing the request. Please refresh the page to try again.",
                        null, { "timeOut": "1000" });
                    console.error(rejection.data);
                }

                return $q.reject(rejection);
            }
        };
    });

});



angular.element(document).ready(function () {
    $.get(baseUrl + '/users/current-user', function (user) {
        angular.module('app').constant('CurrentUser', user);
        angular.bootstrap(document, ['app']);
    });
});





