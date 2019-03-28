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
import MyModule from 'de.appwerft.mp3agic';
const mp3file = MyModule.createMp3file(Ti.Filesystem.getFile(Ti.Filesystem.applicationDataDirectory,
    'test.mp3'));

mp3file.getLengthInSeconds();
mp3file.getBitrate();
mp3file.isVbr();
mp3file.getSampleRate();
mp3file.getId3v1Tag();
mp3file.getId3v2Tag();

Ti.UI.createImageView({
	image : mp3file.getAlbumimage
})    
    
    
```

