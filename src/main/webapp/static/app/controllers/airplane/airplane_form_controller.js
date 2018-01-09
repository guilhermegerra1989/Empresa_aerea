
angular.module('app').controller('AirplaneFormController', function ($scope, airplane, AirplaneService) {

    $scope.airplane = airplane;

    $scope.save = function () {
        AirplaneService.save($scope.airplane);
    };
});