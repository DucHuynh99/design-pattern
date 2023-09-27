package structural.proxy.library;

import java.util.List;

public interface ThirdPartyYouTubeLib {
    List<Video> popularVideos();

    Video getVideo(String id);
}
