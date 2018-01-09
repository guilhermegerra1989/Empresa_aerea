
angular.module('app').factory('PilotService', function ($location, Restangular, CurrentUser, NotificationService) {
    return{
        getResource: function () {
            return Restangular.all('pilot');
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

        save: function (pilot) {
            var p = null;


            if (pilot.id) {
                p = pilot.put();
            } else {

                p = this.getResource().post(pilot);
            }

            p.then(function (pilot) {
                NotificationService.success("Pilot successfully saved.");
                $location.path('/pilot');
            }, function (data) {
                NotificationService.error("The pilot could not be saved. Try again.");
            });

            return p;
        }

    }
});