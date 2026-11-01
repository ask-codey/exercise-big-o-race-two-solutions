// Your five functions. The comment above each one says what it should
// return, with examples. Replace each return line with your own code.

/*
 * Run the task once and return how many milliseconds it took, using
 * performance.now() before and after.
 *
 * timeTask(() => countRepeats(playlist)) -> about 2 (it depends on your computer)
 */
export function timeTask(task: () => void): number {
  return 0;
}

/*
 * The smallest time in the list: the run with the fewest interruptions.
 *
 * fastest([5.2, 3.1, 4.8]) -> 3.1
 */
export function fastest(times: number[]): number {
  return 0;
}

/*
 * The growth rate of countPlays in given.ts, as "O(1)", "O(n)" or "O(n²)".
 * Time it at a size and at double that size (the demo does this),
 * or count its loops.
 */
export function countPlaysRate(): string {
  return "";
}

/*
 * The growth rate of countRepeats in given.ts, as "O(1)", "O(n)" or "O(n²)"
 * ("O(n^2)" is fine too, if you can't type the small 2).
 */
export function countRepeatsRate(): string {
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
export function predictTime(milliseconds: number, growthRate: string, factor: number): number {
  return 0;
}
