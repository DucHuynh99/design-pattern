package structural.proxy.downloader;

import structural.proxy.library.ThirdPartyYouTubeLib;
import structural.proxy.library.Video;

import java.util.List;

public class YoutubeDownloader {
    private final ThirdPartyYouTubeLib api;

    public YoutubeDownloader(ThirdPartyYouTubeLib api) {
        this.api = api;
    }

    public void renderVideoPage(String id) {
        Video video = api.getVideo(id);
        System.out.println("------------------------------");
        System.out.println("Video details:");
        System.out.println(" + ID: " + video.id);
        System.out.println(" + Title: " + video.title);
        System.out.println("------------------------------");
    }

    public void renderPopularVideos() {
        List<Video> videos = api.popularVideos();
        System.out.println("------------------------------");
        System.out.println("Trending videos: ");
        for (Video video : videos) {
            System.out.println(" + ID: " + video.id + " | Title: " + video.title);
        }
        System.out.println("------------------------------");
    }

    public long speedTest() {
        long start = System.currentTimeMillis();
        // User behavior in our app
        renderPopularVideos();
        renderVideoPage("APPLE");
        renderPopularVideos();
        renderVideoPage("SAMSUNG");
        // Users might visit the same page quite often
        renderVideoPage("APPLE");
        renderVideoPage("HUAWEI");
        return System.currentTimeMillis() - start;
    }
}
