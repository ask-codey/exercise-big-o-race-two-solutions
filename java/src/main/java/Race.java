import java.util.List;

// Your five methods. The comment above each one says what it should
// return, with examples. Replace each return line with your own code.
public class Race {
    /*
     * Run the task once and return how many milliseconds it took, using
     * System.nanoTime() before and after (nanoseconds: divide by 1,000,000).
     *
     * timeTask(() -> Given.countRepeats(playlist)) -> about 2 (it depends on your computer)
     */
    public static double timeTask(Runnable task) {
        return 0;
    }

    /*
     * The smallest time in the list: the run with the fewest interruptions.
     *
     * fastest([5.2, 3.1, 4.8]) -> 3.1
     */
    public static double fastest(List<Double> times) {
        return 0;
    }

    /*
     * The growth rate of Given.countPlays, as "O(1)", "O(n)" or "O(n²)".
     * Time it at a size and at double that size (the demo does this),
     * or count its loops.
     */
    public static String countPlaysRate() {
        return "";
    }

    /*
     * The growth rate of Given.countRepeats, as "O(1)", "O(n)" or "O(n²)"
     * ("O(n^2)" is fine too, if you can't type the small 2).
     */
    public static String countRepeatsRate() {
        return "";
    }

    /*
     * Predict a task's time when its data grows `factor` times, from its
     * time now and its growth rate: O(1) stays the same, O(n) grows by the
     * factor, O(n²) (or "O(n^2)") by the factor times itself.
     *
     * predictTime(10, "O(n)", 2) -> 20
     * predictTime(10, "O(n²)", 2) -> 40
     * predictTime(10, "O(1)", 2) -> 10
     */
    public static double predictTime(double milliseconds, String growthRate, int factor) {
        return 0;
    }
}
