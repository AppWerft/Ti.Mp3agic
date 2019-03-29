/**
 * Appcelerator Titanium Mobile
 * Copyright (c) 2011 by Appcelerator, Inc. All Rights Reserved.
 * Licensed under the terms of the Apache Public License
 * Please see the LICENSE included with this distribution for details.
 *
 * Warning: This file is GENERATED, and should not be modified
 */
var bootstrap = kroll.NativeModule.require("bootstrap"),
	invoker = kroll.NativeModule.require("invoker"),
	Titanium = kroll.binding("Titanium").Titanium;

function moduleBootstrap(moduleBinding) {
	function lazyGet(object, binding, name, namespace) {
		return bootstrap.lazyGet(object, binding,
			name, namespace, moduleBinding.getBinding);
	}

	var module = moduleBinding.getBinding("de.appwerft.mp3agic.Mp3agicModule")["Mp3agic"];
	var invocationAPIs = module.invocationAPIs = [];
	module.apiName = "Mp3agic";

	function addInvocationAPI(module, moduleNamespace, namespace, api) {
		invocationAPIs.push({ namespace: namespace, api: api });
	}

	addInvocationAPI(module, "Mp3agic", "Mp3agic", "createAlbumImage");addInvocationAPI(module, "Mp3agic", "Mp3agic", "createMp3file");
		if (!("__propertiesDefined__" in module)) {Object.defineProperties(module, {
"Mp3file": {
get: function() {
var Mp3file =  lazyGet(this, "de.appwerft.mp3agic.Mp3fileProxy", "Mp3file", "Mp3file");
return Mp3file;
},
configurable: true
},
"AlbumImage": {
get: function() {
var AlbumImage =  lazyGet(this, "de.appwerft.mp3agic.AlbumImageProxy", "AlbumImage", "AlbumImage");
return AlbumImage;
},
configurable: true
},

});
module.constructor.prototype.createAlbumImage = function() {
return new module["AlbumImage"](arguments);
}
module.constructor.prototype.createMp3file = function() {
return new module["Mp3file"](arguments);
}
}
module.__propertiesDefined__ = true;
return module;

}
exports.bootstrap = moduleBootstrap;
