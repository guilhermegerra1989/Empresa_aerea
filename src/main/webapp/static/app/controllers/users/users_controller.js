
angular.module('app').controller('UsersController', function ($scope, $location, usersList, UsersService) {
    $scope.usersList = usersList;

    $scope.delete = function (user) {
        UsersService.delete(user);
        
    };

    $scope.updatePage = function (currentPage, itemsPerPage) {
        $location.search({
            currentPage: currentPage,
            itemsPerPage: itemsPerPage
        });
    };
});