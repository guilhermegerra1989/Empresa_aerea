/**
 * Created by rodrigo on 08/04/14.
 */
angular.module('app').directive('ngEqualTo', function () {
    return {
        restrict: 'A',
        require: 'ngModel',
        scope: true,
        link: function ($scope, $element, attrs, ngModelCtrl) {
            var checkMatch = function (value) {
                ngModelCtrl.$setValidity('equalto', ngModelCtrl.$viewValue == value);
            };

            $scope.$watch(attrs.ngEqualTo, checkMatch);

            $element.on('keyup change', function () {
                var value = $scope.$apply(attrs.ngEqualTo);
                checkMatch(value);
                $scope.$digest();
            });

            $scope.$on("$destroy", function () {
                $element.off('keyup change');
            });
        }
    };
});