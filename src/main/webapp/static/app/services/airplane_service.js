
angular.module('app').factory('AirplaneService', function ($location, Restangular, CurrentUser, NotificationService) {
    return{
        getResource: function () {
            return Restangular.all('airplane');
        },

        loadAll: function (params) {
            return this.getResource().getList(params);
        },


        loadAllPaginated: function (page, itemsPerPage) {
            return this.getResource().getList({
                page: page,
                itemsPerPage: itemsPerPage
            });
        },

        load: function (id) {
            return this.getResource().get(id);
        },

        getCurrentUser: function () {
            return CurrentUser;
        },

        create: function () {
            return {
                enabled: true
            };
        },

        save: function (airplane) {
            var p = null;


            if (airplane.id) {
                p = airplane.put();
            } else {

                p = this.getResource().post(airplane);
            }

            p.then(function (airplane) {
                NotificationService.success("Airplane successfully saved.");
                $location.path('/airplane');
            }, function (data) {
                NotificationService.error("The airplane could not be saved. Try again.");
            });

            return p;
        }

    }
});