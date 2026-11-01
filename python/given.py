# The two solutions to race. They're finished: you don't need to change this file.


def count_plays(playlist, title):
    """How many times a title appears on a playlist: reads every title once."""
    plays = 0
    for song in playlist:
        if song == title:
            plays += 1
    return plays


def count_repeats(playlist):
    """How many pairs of songs share a title: compares every song with every other song."""
    repeats = 0
    for first in range(len(playlist)):
        for second in range(first + 1, len(playlist)):
            if playlist[first] == playlist[second]:
                repeats += 1
    return repeats
