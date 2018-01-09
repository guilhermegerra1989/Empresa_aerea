
angular.module('app').controller('UsersFormController', function ($scope, user, UsersService, UsersGroup) {
    $scope.userGroups = UsersGroup;
    $scope.user = user;

    $scope.save = function () {
        UsersService.save($scope.user);
    };
});