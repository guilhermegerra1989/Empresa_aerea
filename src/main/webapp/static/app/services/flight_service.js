
angular.module('app').factory('FlightService', function ($location, Restangular, NotificationService) {
    return{
        getResource: function () {
            return Restangular.all('flight');
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


        create: function () {
            return {
                enabled: true
            };
        },

        save: function (flight) {
            var p = null;


            if (flight.id) {
                p = flight.put();
            } else {

                p = this.getResource().post(flight);
            }

            p.then(function (flight) {
                NotificationService.success("Flight saved successfully.");
                $location.path('/flight');
            }, function (data) {
                NotificationService.error("Failed to save flight. Try again.");
            });

            return p;
        }

    }
});