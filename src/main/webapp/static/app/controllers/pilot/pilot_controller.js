
angular.module('app').controller('PilotController', function ($scope, $location, pilotList, PilotService) {
    $scope.pilotList = pilotList;
    var currentPage = 1;
    var itemsPerPage = 1000;

    $scope.updatePage = function (currentPage, itemsPerPage) {
        $location.search({
            currentPage: currentPage,
            itemsPerPage: itemsPerPage
        });
    };
});