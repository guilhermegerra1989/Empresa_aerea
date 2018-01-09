
angular.module('app').controller('AirplaneController', function ($scope, $location, airplaneList, AirplaneService) {
    $scope.airplaneList = airplaneList;
    var currentPage = 1;
    var itemsPerPage = 1000;

    $scope.updatePage = function (currentPage, itemsPerPage) {
        $location.search({
            currentPage: currentPage,
            itemsPerPage: itemsPerPage
        });
    };
});