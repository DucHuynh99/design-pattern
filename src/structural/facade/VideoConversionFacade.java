package structural.facade;

import structural.facade.library.*;

import java.io.File;

public class VideoConversionFacade {
    public File convertVideo(String fileName, String format) {
        System.out.println("Video Conversion Facade: Conversion started");
        VideoFile file = new VideoFile(fileName);
        Codec srcCodec = CodecFactory.extract(file);
        Codec desCodec = format.equals("mp4") ? new MPEG4CompressionCodec() : new OggCompressionCodec();
        VideoFile buffer = BitrateReader.read(file, srcCodec);
        VideoFile result = BitrateReader.convert(buffer, desCodec);
        System.out.println("Video Conversion Facade: Conversion completed");
        return (new AudioMixer()).fix(result);
    }
}
