
_.mixin({
    fmt: function (tpl) {
        var args = arguments;
        return tpl.replace(/\{(\d+)\}/g, function (m, n) { return args[n]; });
    },

    remove: function (collection, item) {
        collection.splice(_.indexOf(collection, item), 1);
        return collection;
    }
})