
angular.module('app').controller('FlightFormController', function ($scope, flight, City, Status, FlightService, PilotService, AirplaneService) {
   
	$scope.cities = City;
	$scope.status = Status;
    $scope.flight = flight;
    var currentPage = 1;
    var itemsPerPage = 1000;
    
    AirplaneService.loadAllPaginated(currentPage,itemsPerPage).then(function (airplanes) {
	    $scope.airplaneList = airplanes;
	});
    
    PilotService.loadAllPaginated(currentPage,itemsPerPage).then(function (pilot) {
	    $scope.pilots = pilot;
	});

    $scope.save = function () {
    	FlightService.save($scope.flight);
    };
});