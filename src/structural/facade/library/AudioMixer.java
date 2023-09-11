package structural.facade.library;

import java.io.File;

public class AudioMixer {
    public File fix(VideoFile result) {
        System.out.println("AudioMixer: fixing audio..." + result);
        return new File("tmp");
    }
}
