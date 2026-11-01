using System.Diagnostics;
using RaceTwoSolutions;

namespace RaceTwoSolutions.Tests;

// The tests for your methods. You don't need to change this file.
// Each message says what was expected, so a failing test tells you what to look at.

[TestClass]
public class RaceTests
{
    [TestMethod]
    public void TimeTaskRunsTheTaskExactlyOnce()
    {
        int runs = 0;
        Race.TimeTask(() => runs++);
        Assert.AreEqual(1, runs, "Not yet: TimeTask should run the task once, between starting and stopping the stopwatch.");
    }

    [TestMethod]
    public void TimeTaskMeasuresATwentyMillisecondTask()
    {
        double measured = Race.TimeTask(() =>
        {
            Stopwatch wait = Stopwatch.StartNew();
            while (wait.Elapsed.TotalMilliseconds < 20) { }
        });
        Assert.IsTrue(measured >= 15 && measured < 5000, "Not yet: a task that takes 20 ms should measure about 20 ms, but TimeTask returned " + measured + ".");
    }

    [TestMethod]
    public void FastestPicksTheSmallestTime()
    {
        Assert.AreEqual(3.1, Race.Fastest(new List<double> { 5.2, 3.1, 4.8 }), 0.0001, "Not yet: the smallest of 5.2, 3.1 and 4.8 is 3.1.");
        Assert.AreEqual(7.0, Race.Fastest(new List<double> { 7.0 }), 0.0001, "Not yet: one time is its own fastest: 7.0.");
    }

    [TestMethod]
    public void CountPlaysGrowsLinearly()
    {
        Assert.AreEqual("O(n)", Race.CountPlaysRate(), "Not yet: CountPlays reads every title once, so its time doubles when the songs double: O(n).");
    }

    [TestMethod]
    public void CountRepeatsGrowsQuadratically()
    {
        string rate = Race.CountRepeatsRate();
        Assert.IsTrue(rate == "O(n²)" || rate == "O(n^2)", "Not yet: CountRepeats compares every song with every other song, so its time grows about four times when the songs double: O(n²). It returned \"" + rate + "\".");
    }

    [TestMethod]
    public void PredictTimeForLinearGrowsByTheFactor()
    {
        Assert.AreEqual(20, Race.PredictTime(10, "O(n)", 2), 0.0001, "Not yet: O(n) work at 10 ms takes about 20 ms with twice the data.");
        Assert.AreEqual(100, Race.PredictTime(10, "O(n)", 10), 0.0001, "Not yet: O(n) work at 10 ms takes about 100 ms with ten times the data.");
    }

    [TestMethod]
    public void PredictTimeForQuadraticGrowsByTheFactorSquared()
    {
        Assert.AreEqual(40, Race.PredictTime(10, "O(n²)", 2), 0.0001, "Not yet: O(n²) work at 10 ms takes about 40 ms with twice the data.");
        Assert.AreEqual(1000, Race.PredictTime(10, "O(n^2)", 10), 0.0001, "Not yet: O(n^2) work at 10 ms takes about 1,000 ms with ten times the data.");
    }

    [TestMethod]
    public void PredictTimeForConstantStaysTheSame()
    {
        Assert.AreEqual(10, Race.PredictTime(10, "O(1)", 2), 0.0001, "Not yet: O(1) work takes the same 10 ms however much data there is.");
        Assert.AreEqual(10, Race.PredictTime(10, "O(1)", 1000), 0.0001, "Not yet: O(1) work takes the same 10 ms even with a thousand times the data.");
    }
}
