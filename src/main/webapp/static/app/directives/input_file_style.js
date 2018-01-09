/**
 * Created by rodrigo on 3/12/14.
 */
angular.module('app').directive('inputFileStyle', function () {
    return {
        restrict: 'A',
        scope: "=inputFileStyle",
        compile: function (input, attrs, transclude) {

            input.filestyle({buttonName: "btn-primary",
                size:"nr",
                buttonText: 'Importar...'});

            return function (scope, input, attrs, ctrl) {

            };
        }
    };
});
