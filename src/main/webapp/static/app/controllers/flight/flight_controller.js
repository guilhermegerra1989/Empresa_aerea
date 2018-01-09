
angular.module('app').controller('FlightController', function ($scope, $location, flightList, FlightService) {
    $scope.flightList = flightList;
    var currentPage = 1;
    var itemsPerPage = 1000;

    $scope.updatePage = function (currentPage, itemsPerPage) {
        $location.search({
            currentPage: currentPage,
            itemsPerPage: itemsPerPage
        });
    };
    
    $scope.change = function(item){
        $scope.flightChange = item;
    }
    
    
});