package sounds;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.UnsupportedAudioFileException;
import java.io.IOException;
import java.net.URL;

/**
 * Created by thiên on 8/17/2016.
 */
public class SoundManager {
    public static Clip getSound(URL url){
        try {
            AudioInputStream inputStream = AudioSystem.getAudioInputStream(url);
            Clip clip = AudioSystem.getClip();
            clip.open(inputStream);
            return clip;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}
