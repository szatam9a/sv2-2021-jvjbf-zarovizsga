package videos;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.LinkedList;
import java.util.List;

public class VideoPlatform {
    private List<Channel> channels = new LinkedList<>();

    public List<Channel> getChannels() {
        return channels;
    }

    public VideoPlatform() {

    }

    int calculateSumOfVideos() {
        return channels.stream().mapToInt(e -> e.getNumberOfVideos()).sum();
    }


    public void readDataFromFile(Path path) {
        try {
            List<String> file = Files.readAllLines(path);
            file.remove(0);
            file.stream().forEach(this::processData);
        } catch (IOException hacker) {
            throw new IllegalArgumentException("Cannot open file for read!");
        }
    }

    private void processData(String aline) {
        String[] tmp = aline.split(";");
        channels.add(new Channel(tmp[0], Integer.parseInt(tmp[1]), Integer.parseInt(tmp[2])));
    }
}


