/**
 * This file was auto-generated by the Titanium Module SDK helper for Android
 * Appcelerator Titanium Mobile
 * Copyright (c) 2009-2018 by Appcelerator, Inc. All Rights Reserved.
 * Licensed under the terms of the Apache Public License
 * Please see the LICENSE included with this distribution for details.
 *
 */
package de.appwerft.mp3agic;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.HashMap;

import org.apache.commons.lang3.StringEscapeUtils;
import org.appcelerator.kroll.KrollDict;
import org.appcelerator.kroll.KrollModule;
import org.appcelerator.kroll.annotations.Kroll;

import org.appcelerator.titanium.TiApplication;
import org.appcelerator.titanium.TiC;
import org.appcelerator.titanium.io.TiBaseFile;
import org.appcelerator.titanium.io.TiFile;
import org.appcelerator.titanium.io.TiFileFactory;

import com.mpatric.mp3agic.ID3v1;
import com.mpatric.mp3agic.ID3v2;
import com.mpatric.mp3agic.InvalidDataException;
import com.mpatric.mp3agic.Mp3File;
import com.mpatric.mp3agic.UnsupportedTagException;

import ti.modules.titanium.filesystem.FileProxy;

import org.appcelerator.kroll.common.Log;
import org.appcelerator.kroll.common.TiConfig;

@Kroll.module(name = "Mp3agic", id = "de.appwerft.mp3agic")
public class Mp3agicModule extends KrollModule {

	// Standard Debugging variables
	private static final String LCAT = "Mp3agicModule";
	private static final boolean DBG = TiConfig.LOGD;

	// You can define constants with @Kroll.constant, for example:
	// @Kroll.constant public static final String EXTERNAL_NAME = value;

	public Mp3agicModule() {
		super();
	}

	@Kroll.onAppCreate
	public static void onAppCreate(TiApplication app) {
	}

	public static TiBaseFile getTiBaseFileFromInput(Object readPath) {
		if (readPath == null) {
			Log.e(LCAT, "parameter must be a string (path) or a file object");
			return null;
		}

		Log.d(LCAT, readPath.getClass().getName());
		TiBaseFile inputFile = null;
		try {
			if (readPath instanceof TiFile) {
				Log.d(LCAT, "file is TiFile");
				inputFile = TiFileFactory.createTitaniumFile(((TiFile) readPath).getFile().getAbsolutePath(), false);
			} else {
				if (readPath instanceof FileProxy) {
					Log.d(LCAT, "file is FileProxy");
					inputFile = ((FileProxy) readPath).getBaseFile();
				} else {
					if (readPath instanceof TiBaseFile) {
						Log.d(LCAT, "file is TiBaseFile");
						inputFile = (TiBaseFile) readPath;
					} else {
						Log.d(LCAT, "file is String, Assume path provided");
						// Assume path provided
						inputFile = TiFileFactory.createTitaniumFile(readPath.toString(), false);
					}
				}
			}
			if (inputFile == null) {
				Log.d(LCAT, "inputFile is null");
				return null;
			}
			if (!inputFile.exists()) {
				Log.d(LCAT, "inputFile doesn't exists");
				return null;
			}
			return inputFile;

		} catch (Exception e) {
			HashMap<String, Object> errEvent = new HashMap<String, Object>();
			errEvent.put(TiC.PROPERTY_SUCCESS, false);
			errEvent.put("message", e.getMessage());
			Log.e(LCAT, e.getMessage());
		}
		return null;
	}

	public static Mp3File getID3fromMP3File(TiBaseFile inputFile) {
		Log.d(LCAT, inputFile.toString());
		Log.d(LCAT, inputFile.getNativeFile().getAbsolutePath());

		try {
			return new Mp3File(inputFile.getNativeFile());

		} catch (UnsupportedTagException | InvalidDataException | IOException e) {
			Log.e(LCAT, e.getMessage());
			return null;
		}
	}
	@Kroll.method
	public long getDuration(Object arg) {
		TiBaseFile inputFile = getTiBaseFileFromInput(arg);
		Mp3File mp3file = getID3fromMP3File(inputFile);
		if (mp3file == null)
			return 0;
		return mp3file.getLengthInSeconds();
	}
	@Kroll.method
	public KrollDict getId3Tag(Object arg) {
		TiBaseFile inputFile = getTiBaseFileFromInput(arg);
		Mp3File mp3file = getID3fromMP3File(inputFile);
		if (mp3file == null)
			return null;
		KrollDict dict = new KrollDict();
		dict.put("bitrate", mp3file.getBitrate());
		dict.put("channelmode", mp3file.getChannelMode());
		dict.put("emphasis", mp3file.getEmphasis());
		dict.put("endoffset", mp3file.getEndOffset());
		dict.put("filename", mp3file.getFilename());
		dict.put("framecount", mp3file.getFrameCount());
		dict.put("lastmodified", mp3file.getLastModified());
		dict.put("layer", mp3file.getLayer());
		dict.put("length", mp3file.getLength());
		dict.put("duration", mp3file.getLengthInSeconds());
		dict.put("modeextension", mp3file.getModeExtension());
		dict.put("samplerate", mp3file.getSampleRate());
		dict.put("startoffset", mp3file.getStartOffset());
		dict.put("xingbitrate", mp3file.getXingBitrate());
		dict.put("xingoffset", mp3file.getXingOffset());
		dict.put("iscopyright", mp3file.isCopyright());
		dict.put("isoriginal", mp3file.isOriginal());
		dict.put("isvbr", mp3file.isVbr());
		dict.put("hasid3v1tag", mp3file.hasId3v1Tag());
		dict.put("hasid3v2tag", mp3file.hasId3v2Tag());
		return dict;
	}

	@Kroll.method
	public KrollDict getId3v1Tag(Object arg) {
		TiBaseFile inputFile = getTiBaseFileFromInput(arg);
		Mp3File mp3file = getID3fromMP3File(inputFile);
		if (mp3file == null)
			return null;
		KrollDict dict = new KrollDict();
		if (mp3file == null)
			return null;
		if (mp3file.hasId3v1Tag()) {
			ID3v1 id3v1Tag = mp3file.getId3v1Tag();
			dict.put("track", id3v1Tag.getTrack());
			dict.put("artist", id3v1Tag.getArtist());
			dict.put("title", id3v1Tag.getTitle());
			dict.put("album", id3v1Tag.getAlbum());
			dict.put("year", id3v1Tag.getYear());
			dict.put("genre", id3v1Tag.getGenre());
			dict.put("description", id3v1Tag.getGenreDescription());
			dict.put("comment", id3v1Tag.getComment());
			return dict;
		}
		return null;
	}

	@SuppressWarnings("deprecation")
	@Kroll.method
	public KrollDict getId3v2Tag(Object arg) {
		TiBaseFile inputFile = getTiBaseFileFromInput(arg);
		Mp3File mp3file = getID3fromMP3File(inputFile);
		if (mp3file == null)
			return null;

		if (mp3file.hasId3v2Tag()) {
			KrollDict dict = new KrollDict();
			ID3v2 tag = mp3file.getId3v2Tag();
			dict.put("track", tag.getTrack());
			dict.put("artist", tag.getArtist());
			dict.put("title", tag.getTitle());
			dict.put("album", tag.getAlbum());
			dict.put("year", tag.getYear());
			dict.put("genre", tag.getGenre());
			dict.put("description", tag.getGenreDescription());
			dict.put("comment",  StringEscapeUtils.unescapeHtml4(tag.getComment()));
			dict.put("lyrics", StringEscapeUtils.unescapeHtml4(tag.getLyrics()));
			dict.put("composer", tag.getComposer());
			dict.put("publisher", tag.getPublisher());
			dict.put("originalartist", tag.getOriginalArtist());
			dict.put("albumartist", tag.getAlbumArtist());
			dict.put("copyright", tag.getCopyright());
			dict.put("url", tag.getUrl());
			dict.put("encoder", tag.getEncoder());
			return dict;
		}
		return null;
	}

	@Kroll.method
	public String getAlbumimage(Object arg) {
		TiBaseFile inputFile = getTiBaseFileFromInput(arg);
		Mp3File mp3file = getID3fromMP3File(inputFile);
		if (mp3file == null)
			return null;
		if (!mp3file.hasId3v2Tag())
			return null;
		ID3v2 tag = mp3file.getId3v2Tag();
		String mime = tag.getAlbumImageMimeType();
		String[] parts = mime.split("/");
		String suffix = ".png";
		if (parts.length > 1)
			suffix = "." + parts[1];
		File temp;
		try {
			temp = File.createTempFile("albumimage", suffix, TiApplication.getInstance().getCacheDir());
			FileOutputStream fos = null;
			try {
				fos = new FileOutputStream(temp);
				fos.write(tag.getAlbumImage());
			} catch (FileNotFoundException e) {
			} catch (IOException ioe) {
			} finally {
				try {
					if (fos != null) {
						fos.close();
						return "file://" + temp.getAbsolutePath();

					}
				} catch (IOException ioe) {
					System.out.println("Error while closing stream: " + ioe);
				}
			}
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		return null;

	}
      
}
