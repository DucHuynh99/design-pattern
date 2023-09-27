package structural.proxy.proxy;

import structural.proxy.library.ThirdPartyYouTubeLib;
import structural.proxy.library.ThirdPartyYoutubeClass;
import structural.proxy.library.Video;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class YoutubeCacheProxy implements ThirdPartyYouTubeLib {
    private final ThirdPartyYouTubeLib service;
    private List<Video> cachePopular = new ArrayList<>();
    private final Map<String, Video> cacheAll = new HashMap<>();

    public YoutubeCacheProxy() {
        service = new ThirdPartyYoutubeClass();
    }

    @Override
    public List<Video> popularVideos() {
        if (cachePopular.isEmpty()) {
            cachePopular = service.popularVideos();
        }
        return cachePopular;
    }

    @Override
    public Video getVideo(String id) {
        Video video = cacheAll.get(id);
        if (video == null) {
            video = service.getVideo(id);
            cacheAll.put(video.id, video);
        }
        return video;
    }
}
