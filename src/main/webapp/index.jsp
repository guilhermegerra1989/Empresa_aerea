<%@ page contentType="text/html; charset=ISO-8859-1" %>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="utf-8"> 
    <title> Airline Project</title>
    <script type="text/javascript">
        var baseUrl = '<%= request.getContextPath() %>';
    </script>
    <script type="text/javascript" src="<%= request.getContextPath() %>/static/js/lib/underscore.js"></script>

    <script type="text/javascript" src="<%= request.getContextPath() %>/static/js/lib/jquery-2.0.2.min.js"></script>
    <script type="text/javascript" src="<%= request.getContextPath() %>/static/js/lib/jquery.ui.js"></script>
    <script type="text/javascript" src="<%= request.getContextPath() %>/static/js/lib/Highcharts-4.0.1/js/highcharts.js"></script>
  
    <script type="text/javascript" src="<%= request.getContextPath() %>/static/js/lib/angular.js"></script>
    <script type="text/javascript" src="<%= request.getContextPath() %>/static/js/lib/angular-locale_pt-br.js"></script>
    <script type="text/javascript" src="<%= request.getContextPath() %>/static/js/lib/angular-route.js"></script>
    <script type="text/javascript" src="<%= request.getContextPath() %>/static/js/lib/angular-animate.js"></script>
    <script type="text/javascript" src="<%= request.getContextPath() %>/static/js/lib/angular-sanitize.js"></script>
    <script type="text/javascript" src="<%= request.getContextPath() %>/static/js/lib/angular-touch.js"></script>

    <script type="text/javascript" src="<%= request.getContextPath() %>/static/js/lib/loading-bar.js"></script>
    <script type="text/javascript" src="<%= request.getContextPath() %>/static/js/lib/restangular.js"></script> 
    <script type="text/javascript" src="<%= request.getContextPath() %>/static/js/lib/ui-bootstrap-0.10.0.js"></script>  
    <script type="text/javascript" src="<%= request.getContextPath() %>/static/js/lib/bootstrap.min.js"></script>
    <script type="text/javascript" src="<%= request.getContextPath() %>/static/js/lib/angular-touch.min.js"></script>
    <script type="text/javascript" src="<%= request.getContextPath() %>/static/js/lib/angular-carousel.js"></script>
    <script type="text/javascript" src="<%= request.getContextPath() %>/static/js/lib/i18n.js"></script>
    <script type="text/javascript" src="<%= request.getContextPath() %>/static/js/lib/toastr.js"></script>
    <script type="text/javascript" src="<%= request.getContextPath() %>/static/js/base.js"></script>
    <script type="text/javascript" src="<%= request.getContextPath() %>/static/js/utils.js"></script>
    <script type="text/javascript" src="<%= request.getContextPath() %>/static/js/lib/angular-google-chart-gh-pages/ng-google-chart.js"></script>
    <script type="text/javascript" src="<%= request.getContextPath() %>/static/js/lib/highcharts-ng-master/dist/highcharts-ng.js"></script>
    <script type="text/javascript" src="<%= request.getContextPath() %>/static/js/lib/Highcharts-4.0.1/js/highcharts-more.js"></script>
    <script type="text/javascript" src="<%= request.getContextPath() %>/static/js/lib/sortable.js"></script>
    <script type="text/javascript" src="<%= request.getContextPath() %>/static/js/lib//angular-file-upload-shim.min.js"></script>
    <script type="text/javascript" src="<%= request.getContextPath() %>/static/js/lib//angular-file-upload.min.js"></script>
    <script type="text/javascript" src="<%= request.getContextPath() %>/static/js/lib/bootstrap-filestyle.js"> </script>
    <script type="text/javascript" src="<%= request.getContextPath() %>/static/js/lib/moment.min.js"> </script>
    <script type="text/javascript" src="<%= request.getContextPath() %>/static/js/lib/modernizr.min.js"> </script>
  <script type="text/javascript" src="<%= request.getContextPath() %>/static/js/lib/bootstrap-datetimepicker.min.js"> </script>
  
  
    <script type="text/javascript" src="<%= request.getContextPath() %>/static/app/utils.js"></script>
    <script type="text/javascript" src="<%= request.getContextPath() %>/static/app/app.js"></script>
    <script type="text/javascript" src="<%= request.getContextPath() %>/static/app/router.js"></script>
    <script type="text/javascript" src="<%= request.getContextPath() %>/static/app/i18n/translations.js"></script>
    <script type="text/javascript" src="<%= request.getContextPath() %>/static/app/constants/user_groups.js"></script>
    <script type="text/javascript" src="<%= request.getContextPath() %>/static/app/constants/city.js"></script>
    <script type="text/javascript" src="<%= request.getContextPath() %>/static/app/constants/status.js"></script>

    <script type="text/javascript" src="<%= request.getContextPath() %>/static/app/directives/btn_switch.js"></script>
    <script type="text/javascript" src="<%= request.getContextPath() %>/static/app/filters/yes_no_filter.js"></script>
    <script type="text/javascript" src="<%= request.getContextPath() %>/static/app/services/notification_service.js"></script>
    <script type="text/javascript" src="<%= request.getContextPath() %>/static/app/services/users_service.js"></script>
    <script type="text/javascript" src="<%= request.getContextPath() %>/static/app/services/flight_service.js"></script>
    <script type="text/javascript" src="<%= request.getContextPath() %>/static/app/services/pilot_service.js"></script>
    <script type="text/javascript" src="<%= request.getContextPath() %>/static/app/services/airplane_service.js"></script>

    <script type="text/javascript" src="<%= request.getContextPath() %>/static/app/controllers/main_controller.js"></script>
    <script type="text/javascript"  src="<%= request.getContextPath() %>/static/app/controllers/monitor/monitor_controller.js"></script>
	<script type="text/javascript" src="<%= request.getContextPath() %>/static/app/controllers/users/users_controller.js"></script>
    <script type="text/javascript" src="<%= request.getContextPath() %>/static/app/controllers/users/users_form_controller.js"></script>
	<script type="text/javascript" src="<%= request.getContextPath() %>/static/app/controllers/flight/flight_controller.js"></script>
    <script type="text/javascript" src="<%= request.getContextPath() %>/static/app/controllers/flight/flight_form_controller.js"></script>
	<script type="text/javascript" src="<%= request.getContextPath() %>/static/app/controllers/pilot/pilot_controller.js"></script>
    <script type="text/javascript" src="<%= request.getContextPath() %>/static/app/controllers/pilot/pilot_form_controller.js"></script>
	<script type="text/javascript" src="<%= request.getContextPath() %>/static/app/controllers/airplane/airplane_controller.js"></script>
    <script type="text/javascript" src="<%= request.getContextPath() %>/static/app/controllers/airplane/airplane_form_controller.js"></script>

    <link rel="shortcut icon" href="<%=request.getContextPath() %>/static/img/favicon.ico">
    <link href="<%= request.getContextPath() %>/static/css/bootstrap.css" type="text/css" rel="stylesheet">
    <link href="<%= request.getContextPath() %>/static/css/jqueryui.bootstrap.css" type="text/css" rel="stylesheet">
    <link href="<%= request.getContextPath() %>/static/css/loading-bar.css" type="text/css" rel="stylesheet">
    <link href="<%= request.getContextPath() %>/static/css/base.css" type="text/css" rel="stylesheet">
    <link href="<%= request.getContextPath() %>/static/css/animations.css" type="text/css" rel="stylesheet">
    <link href="<%= request.getContextPath() %>/static/css/animate.css" type="text/css" rel="stylesheet">
    <link href='<%= request.getContextPath() %>/static/css/style.css' rel='stylesheet' type='text/css'>

</head>

<body ng-controller="MainController" ng-class="pageClass"  ng-cloak>

<div class="navbar navbar-fixed-top navbar-inverse animated slideInDown">
    <div class="container-fluid">
        <div class="row-fluid">
                <div class="navbar-header">
                    <a class="navbar-brand" href="#/monitor">
                    <img src="<%= request.getContextPath() %>/static/img/logo_flight.png" class="pull-left" style="margin-top:-15px" alt="Flight Control"/>
                    </a>
                </div>
                
                <ul class="col-sm-3 pull-right nav navbar-nav">
                    <li class="dropdown pull-right">
                        <a href="#" class="dropdown-toggle">
                            <i class="fa fa-user"></i>
                            {{currentUser.name}}
                            <i class="caret"></i>
                        </a>

                        <ul class="dropdown-menu">
                            <li has-permission="ADMIN">
                                <a href="#/users">
                                    <i class="fa fa-users"></i>
                                    Usuários
                                </a>
                            </li>
                         
                            <li>
                                <a href="<%= request.getContextPath() %>/logout">
                                    <i class="glyphicon glyphicon-log-out"></i>
                                    Sair
                                </a>
                            </li>
                        </ul>
                    </li>
                </ul>
                
                <ul class="nav navbar-nav pull-right">
	                <li class="dropdown" has-permission="ADMIN">
	                    <a href="#" class="dropdown-toggle"><i class="glyphicon glyphicon-plane"></i>
	                        Airplane <i class="caret"></i>
	                    </a>
	                    <ul role="menu" class="dropdown-menu">
	                        <li has-permission="ADMIN">
	                            <a href="#/airplane">
	                                Airplane
	                            </a>
	                        </li>
	                        <li has-permission="ADMIN, MANAGER">
	                            <a href="#/airplane/new">
	                                New Airplane
	                            </a>
	                        </li>
	                    </ul>
	                </li>
	            </ul>
                
                <ul class="nav navbar-nav pull-right">
	                <li class="dropdown" has-permission="ADMIN">
	                    <a href="#" class="dropdown-toggle"><i class="glyphicon glyphicon-user"></i>
	                        Pilot <i class="caret"></i>
	                    </a>
	                    <ul role="menu" class="dropdown-menu">
	                        <li has-permission="ADMIN">
	                            <a href="#/pilot">
	                                Pilot
	                            </a>
	                        </li>
	                        <li has-permission="ADMIN, MANAGER">
	                            <a href="#/pilot/new">
	                                New Pilot
	                            </a>
	                        </li>
	                    </ul>
	                </li>
	            </ul>
	            
	             <ul class="nav navbar-nav pull-right">
	                <li class="dropdown" has-permission="ADMIN">
	                    <a href="#" class="dropdown-toggle"><i class="glyphicon glyphicon-tasks"></i>
						List of flights <i class="caret"></i>
	                    </a>
	                    <ul role="menu" class="dropdown-menu">
	                        <li has-permission="ADMIN">
	                            <a href="#/flight">
	                                Flight
	                            </a>
	                        </li>
	                        <li has-permission="ADMIN">
	                            <a href="#/flight/new">
	                                New Flight
	                            </a>
	                        </li>
	                    </ul>
	                </li>
	            </ul>
	            
	             <ul class="nav navbar-nav pull-right">
	                <li class="dropdown" has-permission="ADMIN">
	                    <a href="#" class="dropdown-toggle"><i class="glyphicon glyphicon-book"></i>
	                        Contracts <i class="caret"></i>
	                    </a>
	                    <ul role="menu" class="dropdown-menu">
	                        <li has-permission="ADMIN">
	                            <a href="#">
	                                
	                            </a>
	                        </li>
	                    </ul>
	                </li>
	            </ul>
	            
	            <ul class="nav navbar-nav pull-right">
	                <li class="dropdown" has-permission="ADMIN">
	                    <a href="#" class="dropdown-toggle"><i class="glyphicon glyphicon-book"></i>
	                        Airports <i class="caret"></i>
	                    </a>
	                    <ul role="menu" class="dropdown-menu">
	                        <li has-permission="ADMIN">
	                            <a href="#">
	                                
	                            </a>
	                        </li>
	                    </ul>
	                </li>
	            </ul>

            </div>
    </div>
</div>

 <div class="animated fadeIn">
    <div id="view-container" class="container-fluid" ng-view ></div>
</div> 
</body>
</html>