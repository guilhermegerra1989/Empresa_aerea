/**
 * Created by rodrigo on 3/12/14.
 */
angular.module('app').directive('ftsForm', function () {
    return {
        restrict: 'A',
        require: '^form',
        scope: "=ftsForm",
        compile: function (form, attrs, transclude) {
            var formName = attrs.name;
            form.prop('novalidate', true);

            form.find('[ng-model]').each(function () {
                var $me = $(this);
                var name = $me.attr('ng-model').replace(/\./g, '_');

                $me.attr('name', name);

                var errorObjExp = _.fmt("{1}['{2}']", formName, name);
                var feedbackHtml = _.fmt('<i class="{1}" popover="{{{2} | ftsFormMessages}}" popover-trigger="mouseenter" ng-show="{2}.$invalid && {2}.$dirty"></i>',
                    'glyphicon glyphicon-exclamation-sign cursor-pointer form-control-feedback', errorObjExp);

                var $parent = $me.parent();
                var $feedback = $(feedbackHtml);
                var $next = $me.next();

                if ($parent.hasClass('input-group')) {
                    $feedback.css('top', 0);

                    if ($next.hasClass('btn')) {
                        $feedback.css('right', $next.outerWidth() + 10);
                    } else {
                        $feedback.css('right', $next.outerWidth());
                    }
                } else if ($parent.hasClass('btn-group')) {
                    $feedback.css({
                        top: 0,
                        right: $next.outerWidth() + 5
                    });

                }

                if ($parent.parent().hasClass('btn-group-justified')) {
                    $parent.parent().after($feedback);
                } else {
                    $me.after($feedback);
                }
            });

            return function (scope, form, attrs, ctrl) {
                var errorVar = attrs["ftsForm"];
                var submitButton = form.find('button[type=submit]');
                var fields = form.find('[ng-model]');

                scope.$watch(errorVar, function () {
                    var errors = scope[errorVar];

                    if (_.isEmpty(errors))
                        return;

                    _.each(errors, function (value, key) {
                        _.each(value, function (item) {
                            var fieldStatus = ctrl[key];
                            fieldStatus.$dirty = ctrl.$dirty;
                            fieldStatus.$setValidity('server-' + item.toLowerCase(), false);
                        })
                    });
                });

                scope.$watch(function () {
                    submitButton.prop('disabled', ctrl.$invalid);
                });

                fields.each(function () {
                    if (!this.name)
                        return;

                    var $me = $(this);
                    var $formGroup = $me.closest('.form-group');
                    var fieldName = this.name;

                    $me.on("keydown change", function () {
                        var fieldStatus = ctrl[this.name];

                        _.each(fieldStatus.$error, function (value, key) {
                            if (key.match("server")) {
                                fieldStatus.$setValidity(key, true);
                            }
                        });
                    });

                    scope.$watch(_.fmt("{1}.{2}.$invalid", formName, fieldName), function (isInvalid) {
                        $formGroup.toggleClass('has-error has-feedback', ctrl[fieldName]['$dirty'] && ctrl[fieldName]['$invalid']);
                    });
                });

                scope.$on('$destroy', function () {
                    fields.off();
                });
            };
        }
    };
});

angular.module('app').filter('ftsFormMessages', function ($filter) {
    return function (input) {
        if (!input || !input.$error) {
            return;
        }

        var output = '';

        _.some(input.$error, function (value, key) {
            output = $filter('i18n')('validation.' + key);
            return value;
        });

        return output;
    };
});