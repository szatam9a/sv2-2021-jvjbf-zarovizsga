package videos;

public class Channel {
    private String name;
    private int subscribers;
    private int numberOfVideos;

    public String getChannelName() {
        return name;
    }

    public int getSubscribers() {
        return subscribers;
    }

    public int getNumberOfVideos() {
        return numberOfVideos;
    }

    public Channel(String name, int subscribers, int numberOfVideos) {
        this.name = name;
        this.subscribers = subscribers;
        this.numberOfVideos = numberOfVideos;
    }
}
