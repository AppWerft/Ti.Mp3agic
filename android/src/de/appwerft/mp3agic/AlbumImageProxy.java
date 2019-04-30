/**
 * This file was auto-generated by the Titanium Module SDK helper for Android
 * Appcelerator Titanium Mobile
 * Copyright (c) 2009-2017 by Appcelerator, Inc. All Rights Reserved.
 * Licensed under the terms of the Apache Public License
 * Please see the LICENSE included with this distribution for details.
 *
 */
package de.appwerft.mp3agic;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.util.HashMap;

import org.appcelerator.kroll.KrollDict;
import org.appcelerator.kroll.KrollModule;
import org.appcelerator.kroll.KrollProxy;
import org.appcelerator.kroll.annotations.Kroll;
import org.appcelerator.titanium.TiC;
import org.appcelerator.titanium.io.TiBaseFile;
import org.appcelerator.titanium.io.TiFile;
import org.appcelerator.titanium.io.TiFileFactory;
import org.appcelerator.kroll.common.Log;
import org.appcelerator.kroll.common.TiConfig;
import org.appcelerator.titanium.util.TiConvert;
import org.appcelerator.titanium.proxy.TiViewProxy;
import org.appcelerator.titanium.view.TiCompositeLayout;
import org.appcelerator.titanium.view.TiCompositeLayout.LayoutArrangement;
import android.media.MediaMetadataRetriever;
import com.mpatric.mp3agic.ID3v2;
import com.mpatric.mp3agic.InvalidDataException;
import com.mpatric.mp3agic.Mp3File;
import com.mpatric.mp3agic.UnsupportedTagException;

import org.appcelerator.titanium.view.TiUIView;

import android.app.Activity;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.view.ViewGroup.LayoutParams;
import android.widget.ImageView;
import android.widget.LinearLayout;
import ti.modules.titanium.filesystem.FileProxy;

// This proxy can be created by calling Ssss.createExample({message: "hello world"})
@Kroll.proxy(creatableInModule = Mp3agicModule.class)
public class AlbumImageProxy extends TiViewProxy {
	// Standard Debugging variables
	private static final String LCAT = Mp3agicModule.LCAT;

	private Mp3File mp3file;
	private ImageView albumView;
	private Bitmap bitmap;

	private class TiAlbumView extends TiUIView {
		public TiAlbumView(TiViewProxy proxy) {
			super(proxy);
			LayoutParams lp = new LayoutParams(LayoutParams.WRAP_CONTENT, LayoutParams.WRAP_CONTENT);
			LinearLayout container = new LinearLayout(proxy.getActivity());
			container.setLayoutParams(lp);
			albumView = new ImageView(proxy.getActivity());
			albumView.setImageBitmap(bitmap);
			container.addView(albumView);
			setNativeView(container);
		}

		@Override
		public void processProperties(KrollDict d) {
			super.processProperties(d);
		}
	}

	public AlbumImageProxy() {
		super();
	}

	public AlbumImageProxy(KrollDict opts) {
		super();
	}

	@Override
	public TiUIView createView(Activity activity) {
		TiUIView view = new TiAlbumView(this);
		view.getLayoutParams().autoFillsHeight = true;
		view.getLayoutParams().autoFillsWidth = true;
		return view;
	}

	// Handle creation options
	@Override
	public void handleCreationDict(KrollDict opts) {
		TiBaseFile inputFile = null;
		if (!opts.containsKeyAndNotNull(TiC.PROPERTY_IMAGE))
			throw new IllegalArgumentException("missing property " + TiC.PROPERTY_IMAGE);
		inputFile = Mp3agicModule.getTiBaseFileFromInput(opts.get(TiC.PROPERTY_IMAGE));
		Mp3File mp3file = Mp3agicModule.getID3fromMP3File(inputFile);
		try {
			mp3file = new Mp3File(inputFile.getNativeFile());
			if (mp3file.hasId3v2Tag()) {
				bitmap=getCoverImage(inputFile.nativePath());
			}
		} catch (UnsupportedTagException | InvalidDataException | IOException e) {
			e.printStackTrace();
		}
	}

	// https://github.com/mpatric/mp3agic/issues/135
	private Bitmap getCoverImage(String filePath) {
		MediaMetadataRetriever mmr = new MediaMetadataRetriever();
		mmr.setDataSource(filePath);
		byte[] imageData = mmr.getEmbeddedPicture();
		Log.d(LCAT,bytesToHex(imageData));
		if (imageData != null) {
			return BitmapFactory.decodeStream(new ByteArrayInputStream(imageData));
		}
		return null;
	}
	 private static String bytesToHex(byte[] hashInBytes) {

	        StringBuilder sb = new StringBuilder();
	        for (byte b : hashInBytes) {
	            sb.append(String.format("%02x", b));
	        }
	        return sb.toString();

	    }
}
