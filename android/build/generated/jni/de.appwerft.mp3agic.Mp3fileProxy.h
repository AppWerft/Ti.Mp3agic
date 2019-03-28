/**
 * Appcelerator Titanium Mobile
 * Copyright (c) 2011-2018 by Appcelerator, Inc. All Rights Reserved.
 * Licensed under the terms of the Apache Public License
 * Please see the LICENSE included with this distribution for details.
 */

/** This is generated, do not edit by hand. **/

#include <jni.h>

#include "Proxy.h"

namespace de {
namespace appwerft {
namespace mp3agic {
	namespace mp3agic {

class Mp3fileProxy : public titanium::Proxy
{
public:
	explicit Mp3fileProxy();

	static void bindProxy(v8::Local<v8::Object>, v8::Local<v8::Context>);
	static v8::Local<v8::FunctionTemplate> getProxyTemplate(v8::Isolate*);
	static v8::Local<v8::FunctionTemplate> getProxyTemplate(v8::Local<v8::Context>);
	static void dispose(v8::Isolate*);

	static jclass javaClass;

private:
	static v8::Persistent<v8::FunctionTemplate> proxyTemplate;

	// Methods -----------------------------------------------------------
	static void createAlbumimage(const v8::FunctionCallbackInfo<v8::Value>&);
	static void getBitrate(const v8::FunctionCallbackInfo<v8::Value>&);
	static void getLengthInSeconds(const v8::FunctionCallbackInfo<v8::Value>&);
	static void getSampleRate(const v8::FunctionCallbackInfo<v8::Value>&);
	static void getAlbumimage(const v8::FunctionCallbackInfo<v8::Value>&);
	static void getId3v2Tag(const v8::FunctionCallbackInfo<v8::Value>&);
	static void getId3v1Tag(const v8::FunctionCallbackInfo<v8::Value>&);

	// Dynamic property accessors ----------------------------------------
	static void getter_albumimage(v8::Local<v8::Name> name, const v8::PropertyCallbackInfo<v8::Value>& info);
	static void getter_bitrate(v8::Local<v8::Name> name, const v8::PropertyCallbackInfo<v8::Value>& info);
	static void getter_lengthInSeconds(v8::Local<v8::Name> name, const v8::PropertyCallbackInfo<v8::Value>& info);
	static void getter_sampleRate(v8::Local<v8::Name> name, const v8::PropertyCallbackInfo<v8::Value>& info);
	static void getter_id3v2Tag(v8::Local<v8::Name> name, const v8::PropertyCallbackInfo<v8::Value>& info);
	static void getter_id3v1Tag(v8::Local<v8::Name> name, const v8::PropertyCallbackInfo<v8::Value>& info);

};

	} // namespace mp3agic
} // mp3agic
} // appwerft
} // de
