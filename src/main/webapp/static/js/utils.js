function url(path) {
	var args = Array.prototype.slice.call(arguments, 1);
	
	path = BASE_URL + path;
	
	for (var i = 0; i < args.length; i++) {
		path += "/" + args[i];
	}
	
	return path;
}

function getUrlPathParam(number) {
    var params = document.location.pathname.split('/');
    return params[number + 1];
}

function findWithAttr(array, attr, value) {
    for(var i = 0; i < array.length; i += 1) {
        if(array[i][attr] === value) {
            return i;
        }
    }
}
