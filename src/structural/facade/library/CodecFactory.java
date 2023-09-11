package structural.facade.library;

public class CodecFactory {
    public static Codec extract(VideoFile file) {
        if (file.getCodecType().equals("mp4")) {
            System.out.println("Codec Factory: extracting MPEG audio...");
            return new MPEG4CompressionCodec();
        } else {
            System.out.println("Codec Factory: extracting OGG audio...");
            return new OggCompressionCodec();
        }
    }
}
