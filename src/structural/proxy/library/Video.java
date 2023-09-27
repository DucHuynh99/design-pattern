package structural.proxy.library;

public class Video {
    public String id;
    public String title;

    public Video(String id) {
        this.id = id;
        this.title = "video-title-" + id;
    }
}
