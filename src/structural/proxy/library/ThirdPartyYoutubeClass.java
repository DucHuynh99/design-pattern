package structural.proxy.library;

import java.util.List;

public class ThirdPartyYoutubeClass implements ThirdPartyYouTubeLib {
    @Override
    public List<Video> popularVideos() {
        connectToServer();
        return List.of(
                new Video(String.valueOf(System.currentTimeMillis())),
                new Video(String.valueOf(System.currentTimeMillis())),
                new Video(String.valueOf(System.currentTimeMillis()))
        );
    }

    @Override
    public Video getVideo(String id) {
        connectToServer();
        return new Video(id);
    }

    private void connectToServer() {
        try {
            Thread.sleep(100);
        } catch (InterruptedException ex) {
            System.out.println(ex.getMessage());
        }
    }
}
