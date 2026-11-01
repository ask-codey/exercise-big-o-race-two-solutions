// Races the two given solutions at four sizes. Run it with: node demo.ts
// Your times will be different from anyone else's: look at how they change from row to row.
import { countRepeats, countPlays } from "./given.ts";
import { countRepeatsRate, countPlaysRate, fastest, predictTime, timeTask } from "./race.ts";

let lastPairs = 0;
console.log("Songs   count plays (ms)   count repeats (ms)");
for (const songs of [500, 1000, 2000, 4000]) {
  const playlist: string[] = [];
  for (let number = 0; number < songs; number++) {
    playlist.push(`Song ${number}`);
  }
  const playsTimes: number[] = [];
  const pairsTimes: number[] = [];
  for (let run = 0; run < 5; run++) {
    playsTimes.push(timeTask(() => countPlays(playlist, "Golden Hour")));
    pairsTimes.push(timeTask(() => countRepeats(playlist)));
  }
  lastPairs = fastest(pairsTimes);
  console.log(`${songs}   ${fastest(playsTimes).toFixed(3)}   ${lastPairs.toFixed(3)}`);
}
console.log(`count plays grows like ${countPlaysRate()}; count repeats grows like ${countRepeatsRate()}`);
console.log(`Predicted count repeats time for 8000 songs: ${predictTime(lastPairs, countRepeatsRate(), 2).toFixed(3)} ms`);
