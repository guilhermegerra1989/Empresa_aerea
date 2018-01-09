
angular.module('app').controller('PilotFormController', function ($scope, pilot, PilotService) {

    $scope.pilot = pilot;

    $scope.save = function () {
        PilotService.save($scope.pilot);
    };
});