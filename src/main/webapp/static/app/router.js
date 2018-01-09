angular.module('app').config(function ($routeProvider, $locationProvider) {


    $routeProvider.when('/', {
        templateUrl: '/static/app/templates/monitor/list.html',
        controller: 'MonitorController',
        resolve: {
          
        }
    });
	
	
	  /*--------------USERS---------------*/
    $routeProvider.when('/users/new', {
        templateUrl: '/static/app/templates/users/form.html',
        controller: 'UsersFormController',
        resolve: {
            user: function (UsersService) {
                return UsersService.create();
            }
        }
    });

    $routeProvider.when('/users', {
        templateUrl: '/static/app/templates/users/list.html',
        controller: 'UsersController',
        resolve: {
            usersList: function ($route, UsersService) {
                var currentPage = $route.current.params.currentPage || 1;
                var itemsPerPage = $route.current.params.itemsPerPage || 10;
                return UsersService.loadAllPaginated(currentPage, itemsPerPage);
            }
        }
    });

    $routeProvider.when('/users/:id', {
        templateUrl: '/static/app/templates/users/form.html',
        controller: 'UsersFormController',
        resolve: {
            user: function ($route, UsersService) {
                return UsersService.load($route.current.params.id);
            }
        }
    });

    /*--------------PILOT---------------*/
    $routeProvider.when('/airplane/new', {
        templateUrl: '/static/app/templates/airplane/form.html',
        controller: 'AirplaneFormController',
        resolve: {
        	airplane: function (AirplaneService) {
                return AirplaneService.create();
            }
        }
    });

    $routeProvider.when('/airplane', {
        templateUrl: '/static/app/templates/airplane/list.html',
        controller: 'AirplaneController',
        resolve: {
            airplaneList: function ($route, AirplaneService) {
                var currentPage = $route.current.params.currentPage || 1;
                var itemsPerPage = $route.current.params.itemsPerPage || 10;
                return AirplaneService.loadAllPaginated(currentPage, itemsPerPage);
            }
        }
    });

    $routeProvider.when('/airplane/:id', {
        templateUrl: '/static/app/templates/airplane/form.html',
        controller: 'AirplaneFormController',
        resolve: {
        	airplane: function ($route, AirplaneService) {
                return AirplaneService.load($route.current.params.id);
            }
        }
    });
    
    /*--------------PILOT---------------*/
    $routeProvider.when('/pilot/new', {
        templateUrl: '/static/app/templates/pilot/form.html',
        controller: 'PilotFormController',
        resolve: {
        	pilot: function (PilotService) {
                return PilotService.create();
            }
        }
    });

    $routeProvider.when('/pilot', {
        templateUrl: '/static/app/templates/pilot/list.html',
        controller: 'PilotController',
        resolve: {
            pilotList: function ($route, PilotService) {
                var currentPage = $route.current.params.currentPage || 1;
                var itemsPerPage = $route.current.params.itemsPerPage || 10;
                return PilotService.loadAllPaginated(currentPage, itemsPerPage);
            }
        }
    });

    $routeProvider.when('/pilot/:id', {
        templateUrl: '/static/app/templates/pilot/form.html',
        controller: 'PilotFormController',
        resolve: {
            pilot: function ($route, PilotService) {
                return PilotService.load($route.current.params.id);
            }
        }
    });

    
    /*--------------FLIGHT---------------*/
    $routeProvider.when('/flight/new', {
        templateUrl: '/static/app/templates/flight/form.html',
        controller: 'FlightFormController',
        resolve: {
        	flight: function (FlightService) {
                return FlightService.create();
            }
        }
    });

    $routeProvider.when('/flight', {
        templateUrl: '/static/app/templates/flight/list.html',
        controller: 'FlightController',
        resolve: {
            flightList: function ($route, FlightService) {
                var currentPage = $route.current.params.currentPage || 1;
                var itemsPerPage = $route.current.params.itemsPerPage || 10;
                return FlightService.loadAllPaginated(currentPage, itemsPerPage);
            }
        }
    });

    $routeProvider.when('/flight/:id', {
        templateUrl: '/static/app/templates/flight/form.html',
        controller: 'FlightFormController',
        resolve: {
            flight: function ($route, FlightService) {
                return FlightService.load($route.current.params.id);
            }
        }
    });


    $locationProvider.html5Mode(false);

    $routeProvider.otherwise({
        redirectTo: '/'
    });
});