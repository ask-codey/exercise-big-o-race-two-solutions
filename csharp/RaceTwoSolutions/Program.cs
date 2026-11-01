using RaceTwoSolutions;

// Races the two given solutions at four sizes. Run it with: dotnet run --project RaceTwoSolutions
// Your times will be different from anyone else's: look at how they change from row to row.
double lastPairs = 0;
Console.WriteLine("Songs   count plays (ms)   count repeats (ms)");
foreach (int songs in new int[] { 500, 1000, 2000, 4000 })
{
    List<string> playlist = new List<string>();
    for (int number = 0; number < songs; number++)
    {
        playlist.Add("Song " + number);
    }
    List<double> playsTimes = new List<double>();
    List<double> pairsTimes = new List<double>();
    for (int run = 0; run < 5; run++)
    {
        playsTimes.Add(Race.TimeTask(() => Given.CountPlays(playlist, "Golden Hour")));
        pairsTimes.Add(Race.TimeTask(() => Given.CountRepeats(playlist)));
    }
    lastPairs = Race.Fastest(pairsTimes);
    Console.WriteLine(songs + "   " + Race.Fastest(playsTimes).ToString("F3") + "   " + lastPairs.ToString("F3"));
}
Console.WriteLine("count plays grows like " + Race.CountPlaysRate() + "; count repeats grows like " + Race.CountRepeatsRate());
Console.WriteLine("Predicted count repeats time for 8000 songs: " + Race.PredictTime(lastPairs, Race.CountRepeatsRate(), 2).ToString("F3") + " ms");
