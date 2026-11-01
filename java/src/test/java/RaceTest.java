import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.List;
import org.junit.jupiter.api.Test;

// The tests for your methods. You don't need to change this file.
// Each message says what was expected, so a failing test tells you what to look at.
class RaceTest {
    @Test
    void timeTaskRunsTheTaskExactlyOnce() {
        int[] runs = {0};
        Race.timeTask(() -> runs[0]++);
        assertEquals(1, runs[0], "Not yet: timeTask should run the task once, between reading the clock before and after.");
    }

    @Test
    void timeTaskMeasuresATwentyMillisecondTask() {
        double measured = Race.timeTask(() -> {
            long start = System.nanoTime();
            while (System.nanoTime() - start < 20_000_000L) { }
        });
        assertTrue(measured >= 15 && measured < 5000, "Not yet: a task that takes 20 ms should measure about 20 ms, but timeTask returned " + measured + ".");
    }

    @Test
    void fastestPicksTheSmallestTime() {
        assertEquals(3.1, Race.fastest(List.of(5.2, 3.1, 4.8)), 0.0001, "Not yet: the smallest of 5.2, 3.1 and 4.8 is 3.1.");
        assertEquals(7.0, Race.fastest(List.of(7.0)), 0.0001, "Not yet: one time is its own fastest: 7.0.");
    }

    @Test
    void countPlaysGrowsLinearly() {
        assertEquals("O(n)", Race.countPlaysRate(), "Not yet: countPlays reads every title once, so its time doubles when the songs double: O(n).");
    }

    @Test
    void countRepeatsGrowsQuadratically() {
        String rate = Race.countRepeatsRate();
        assertTrue(rate.equals("O(n²)") || rate.equals("O(n^2)"), "Not yet: countRepeats compares every song with every other song, so its time grows about four times when the songs double: O(n²). It returned \"" + rate + "\".");
    }

    @Test
    void predictTimeForLinearGrowsByTheFactor() {
        assertEquals(20, Race.predictTime(10, "O(n)", 2), 0.0001, "Not yet: O(n) work at 10 ms takes about 20 ms with twice the data.");
        assertEquals(100, Race.predictTime(10, "O(n)", 10), 0.0001, "Not yet: O(n) work at 10 ms takes about 100 ms with ten times the data.");
    }

    @Test
    void predictTimeForQuadraticGrowsByTheFactorSquared() {
        assertEquals(40, Race.predictTime(10, "O(n²)", 2), 0.0001, "Not yet: O(n²) work at 10 ms takes about 40 ms with twice the data.");
        assertEquals(1000, Race.predictTime(10, "O(n^2)", 10), 0.0001, "Not yet: O(n^2) work at 10 ms takes about 1,000 ms with ten times the data.");
    }

    @Test
    void predictTimeForConstantStaysTheSame() {
        assertEquals(10, Race.predictTime(10, "O(1)", 2), 0.0001, "Not yet: O(1) work takes the same 10 ms however much data there is.");
        assertEquals(10, Race.predictTime(10, "O(1)", 1000), 0.0001, "Not yet: O(1) work takes the same 10 ms even with a thousand times the data.");
    }
}
