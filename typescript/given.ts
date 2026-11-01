// The two solutions to race. They're finished: you don't need to change this file.

// How many times a title appears on a playlist: reads every title once.
export function countPlays(playlist: string[], title: string): number {
  let plays = 0;
  for (const song of playlist) {
    if (song === title) {
      plays++;
    }
  }
  return plays;
}

// How many pairs of songs share a title: compares every song with every other song.
export function countRepeats(playlist: string[]): number {
  let repeats = 0;
  for (let first = 0; first < playlist.length; first++) {
    for (let second = first + 1; second < playlist.length; second++) {
      if (playlist[first] === playlist[second]) {
        repeats++;
      }
    }
  }
  return repeats;
}
