package bug_catch;

import java.io.*;
import java.io.File;
import java.io.IOException;

import javax.sound.sampled.AudioFormat;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.DataLine;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.SourceDataLine;

/**
 * A simple Java sound file example (i.e., Java code to play a sound file).
 * AudioStream and AudioPlayer code comes from a javaworld.com example.
 * @author alvin alexander, devdaily.com.
 */

public class SoundTest{
	
  public static void main(String[] args) 
  
  throws Exception
  {
    // open the sound file as a Java input stream
    String gongFile = "/Users/al/DevDaily/Projects/MeditationApp/resources/gong.au";
    InputStream in = new FileInputStream(gongFile);

    // create an audiostream from the inputstream
    AudioStream audioStream = new AudioStream(in);

    // play the audio clip with the audioplayer class
    AudioPlayer.player.start(audioStream);
  }
}

private void playSound() 
{
  try
  {
    // get the sound file as a resource out of my jar file;
    // the sound file must be in the same directory as this class file.
    // the input stream portion of this recipe comes from a javaworld.com article.
    InputStream inputStream = getClass().getResourceAsStream(SOUND_FILENAME);
    AudioStream audioStream = new AudioStream(inputStream);
    AudioPlayer.player.start(audioStream);
  }
  catch (Exception e)
  {
    // a special way i'm handling logging in this application
    if (debugFileWriter!=null) e.printStackTrace(debugFileWriter);
  }
}