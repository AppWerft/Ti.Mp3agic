# Ti.Mp3agic

Module for extracting ID3 from mp3.

## Install

To use your module locally inside an app you can copy the zip file into the app root folder and compile your app.
The file will automatically be extracted and copied into the correct `modules/` folder.

If you want to use your module globally in all your apps you have to do the following:

### macOS

Copy the distribution zip file into the `~/Library/Application Support/Titanium` folder

### Linux

Copy the distribution zip file into the `~/.titanium` folder


## Project Usage

Register your module with your application by editing `tiapp.xml` and adding your module.
Example:

<modules>
  <module version="1.0.0">de.appwerft.mp3agic</module>
</modules>

When you run your project, the compiler will combine your module along with its dependencies
and assets into the application.

## Example Usage


### ES6+ (recommended)

```js
import ID3Module from 'de.appwerft.mp3agic';

const mp3file = Ti.Filesystem.getFile(Ti.Filesystem.applicationDataDirectory,
    'test.mp3');
const ID3 = ID3Module.createID3(mp3file);

ID3.getLengthInSeconds();
ID3.getBitrate();
ID3.isVbr();
ID3.getSampleRate();
ID3.getId3v1Tag();
ID3.getId3v2Tag();

if (ID3.hasId3v2Tag) {
	ID3Module.createAlbumView({
		width : 100,
		height : 100,
		image : mp3file
	})    
}    
```

