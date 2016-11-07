var exec = require('cordova/exec');

exports.load = function(success, error,url) {
    exec(success, error, "MKwebviewPlugin", "load", [url]);
};
