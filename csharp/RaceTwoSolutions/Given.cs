namespace RaceTwoSolutions;

// The two solutions to race. They're finished: you don't need to change this file.
public static class Given
{
    // How many times a title appears on a playlist: reads every title once.
    public static int CountPlays(List<string> playlist, string title)
    {
        int plays = 0;
        foreach (string song in playlist)
        {
            if (song == title)
            {
                plays++;
            }
        }
        return plays;
    }

    // How many pairs of songs share a title: compares every song with every other song.
    public static int CountRepeats(List<string> playlist)
    {
        int repeats = 0;
        for (int first = 0; first < playlist.Count; first++)
        {
            for (int second = first + 1; second < playlist.Count; second++)
            {
                if (playlist[first] == playlist[second])
                {
                    repeats++;
                }
            }
        }
        return repeats;
    }
}
