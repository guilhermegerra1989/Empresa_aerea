
angular.module('app').factory('NotificationService', function () {
    toastr.options.timeOut = 1000;
    return toastr;
});
