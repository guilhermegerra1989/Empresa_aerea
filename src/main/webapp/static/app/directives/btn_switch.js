/**
 * Created by rodrigo on 24/03/14.
 */
angular.module('app').directive('btnSwitch', function () {
    return {
        restrict: 'E',
        require: '^ngModel',
        scope: true,
        templateUrl: "/static/app/templates/directives/btn_switch.html",
        link: function (scope, element, attrs, ngModel) {
            scope.setValue = function (value) {
                ngModel.$setViewValue(value);
            };

            scope.getValue = function () {
                return ngModel.$viewValue;
            };
        }
    };
});