/**
 * angular-strap
 * @version v2.0.0-rc.2 - 2014-01-29
 * @link http://mgcrea.github.io/angular-strap
 * @author [object Object]
 * @license MIT License, http://www.opensource.org/licenses/MIT
 */
angular.module('mgcrea.ngStrap.tab').run(['$templateCache', function($templateCache) {
  'use strict';

  $templateCache.put('tab/tab.tpl.html',
    "<ul class=\"nav nav-tabs\"><li ng-repeat=\"pane in panes\" ng-class=\"{active: $getEquipments == active}\"><a data-toggle=\"tab\" ng-click=\"setActive($getEquipments, $event)\" data-getEquipments=\"{{$getEquipments}}\">{{pane.title}}</a></li></ul><div class=\"tab-content\"><div ng-repeat=\"pane in panes\" class=\"tab-pane\" ng-class=\"[$getEquipments == active ? 'active' : '']\" ng-include=\"pane.template || '$pane'\"></div></div>"
  );

}]);
