import java.util.ArrayList;
import java.util.List;

// Races the two given solutions at four sizes. Run it with: java src/main/java/Demo.java
// Your times will be different from anyone else's: look at how they change from row to row.
public class Demo {
    // Each result is kept here, so Java's JIT compiler can't skip work whose answer is never used.
    static long results = 0;

    public static void main(String[] args) {
        double lastPairs = 0;
        System.out.println("Songs   count plays (ms)   count repeats (ms)");
        for (int songs : new int[] {500, 1000, 2000, 4000}) {
            List<String> playlist = new ArrayList<>();
            for (int number = 0; number < songs; number++) {
                playlist.add("Song " + number);
            }
            List<Double> playsTimes = new ArrayList<>();
            List<Double> pairsTimes = new ArrayList<>();
            for (int run = 0; run < 5; run++) {
                playsTimes.add(Race.timeTask(() -> results += Given.countPlays(playlist, "Golden Hour")));
                pairsTimes.add(Race.timeTask(() -> results += Given.countRepeats(playlist)));
            }
            lastPairs = Race.fastest(pairsTimes);
            System.out.println(songs + "   " + String.format("%.3f", Race.fastest(playsTimes)) + "   " + String.format("%.3f", lastPairs));
        }
        System.out.println("count plays grows like " + Race.countPlaysRate() + "; count repeats grows like " + Race.countRepeatsRate());
        System.out.println("Predicted count repeats time for 8000 songs: " + String.format("%.3f", Race.predictTime(lastPairs, Race.countRepeatsRate(), 2)) + " ms");
    }
}
