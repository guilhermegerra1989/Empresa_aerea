/**
 * Created by rodrigo on 09/04/14.
 */
angular.module('app').directive('hasPermission', function (UsersService) {
    return {
        restrict: 'A',
        link: function ($scope, $element, attrs, ctrl) {
            var currentUser = UsersService.getCurrentUser();
            var requiredPermissions = attrs.hasPermission.split(/,\s?/);

            if (requiredPermissions.indexOf(currentUser.group) == -1) {
                $element.hide();
            }
        }
    }
});
