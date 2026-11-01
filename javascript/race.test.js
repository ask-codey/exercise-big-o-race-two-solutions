// The tests for your functions. You don't need to change this file.
// Each message says what was expected, so a failing test tells you what to look at.
import assert from "node:assert/strict";
import { test } from "node:test";
import { countRepeatsRate, countPlaysRate, fastest, predictTime, timeTask } from "./race.js";

test("time task runs the task exactly once", () => {
  let runs = 0;
  timeTask(() => {
    runs++;
  });
  assert.equal(runs, 1, "Not yet: timeTask should run the task once, between reading the clock before and after.");
});

test("time task measures a twenty-millisecond task", () => {
  const measured = timeTask(() => {
    const start = performance.now();
    while (performance.now() - start < 20) {
      // wait
    }
  });
  assert.ok(measured >= 15 && measured < 5000, `Not yet: a task that takes 20 ms should measure about 20 ms, but timeTask returned ${measured}.`);
});

test("fastest picks the smallest time", () => {
  assert.equal(fastest([5.2, 3.1, 4.8]), 3.1, "Not yet: the smallest of 5.2, 3.1 and 4.8 is 3.1.");
  assert.equal(fastest([7.0]), 7.0, "Not yet: one time is its own fastest: 7.0.");
});

test("count plays grows linearly", () => {
  assert.equal(countPlaysRate(), "O(n)", "Not yet: countPlays reads every title once, so its time doubles when the songs double: O(n).");
});

test("count repeats grows quadratically", () => {
  const rate = countRepeatsRate();
  assert.ok(rate === "O(n²)" || rate === "O(n^2)", `Not yet: countRepeats compares every song with every other song, so its time grows about four times when the songs double: O(n²). It returned "${rate}".`);
});

test("predict time for linear grows by the factor", () => {
  assert.equal(predictTime(10, "O(n)", 2), 20, "Not yet: O(n) work at 10 ms takes about 20 ms with twice the data.");
  assert.equal(predictTime(10, "O(n)", 10), 100, "Not yet: O(n) work at 10 ms takes about 100 ms with ten times the data.");
});

test("predict time for quadratic grows by the factor squared", () => {
  assert.equal(predictTime(10, "O(n²)", 2), 40, "Not yet: O(n²) work at 10 ms takes about 40 ms with twice the data.");
  assert.equal(predictTime(10, "O(n^2)", 10), 1000, "Not yet: O(n^2) work at 10 ms takes about 1,000 ms with ten times the data.");
});

test("predict time for constant stays the same", () => {
  assert.equal(predictTime(10, "O(1)", 2), 10, "Not yet: O(1) work takes the same 10 ms however much data there is.");
  assert.equal(predictTime(10, "O(1)", 1000), 10, "Not yet: O(1) work takes the same 10 ms even with a thousand times the data.");
});
