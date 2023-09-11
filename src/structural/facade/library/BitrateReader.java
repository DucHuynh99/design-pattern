package structural.facade.library;

public class BitrateReader {
    public static VideoFile read(VideoFile file, Codec codec) {
        System.out.println("Bitrate Reader: reading file..." + codec);
        return file;
    }

    public static VideoFile convert(VideoFile buffer, Codec codec) {
        System.out.println("Bitrate Reader: writing file..." + codec);
        return buffer;
    }
}
