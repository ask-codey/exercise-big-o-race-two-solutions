import java.util.List;

// The two solutions to race. They're finished: you don't need to change this file.
public class Given {
    // How many times a title appears on a playlist: reads every title once.
    public static int countPlays(List<String> playlist, String title) {
        int plays = 0;
        for (String song : playlist) {
            if (song.equals(title)) {
                plays++;
            }
        }
        return plays;
    }

    // How many pairs of songs share a title: compares every song with every other song.
    public static int countRepeats(List<String> playlist) {
        int repeats = 0;
        for (int first = 0; first < playlist.size(); first++) {
            for (int second = first + 1; second < playlist.size(); second++) {
                if (playlist.get(first).equals(playlist.get(second))) {
                    repeats++;
                }
            }
        }
        return repeats;
    }
}
