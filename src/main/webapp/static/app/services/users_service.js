
angular.module('app').factory('UsersService', function ($location, Restangular, CurrentUser, NotificationService) {
    return{
        getResource: function () {
            return Restangular.all('users');
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

        save: function (user) {
            var p = null;


            if (user.id) {
                p = user.put();
            } else {

                p = this.getResource().post(user);
            }

            p.then(function (user) {
                NotificationService.success("Successfully saved user.");
                $location.path('/users');
            }, function (data) {
                NotificationService.error("The user could not be saved. Try again.");
            });

            return p;
        }

    }
});