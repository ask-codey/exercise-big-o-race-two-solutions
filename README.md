# Exercise: Race Two Solutions

Exercise code for the lesson **Exercise: Race Two Solutions** in the course *Data Structures and Big-O, Demystified* on [ask-codey.com](https://www.ask-codey.com).

## The ticket

> **From:** the product manager
>
> Before we launch the "repeats report" for big libraries, I need two answers with numbers, not guesses: how does the report's time grow as a library grows, and roughly how long will it take for a 64,000-song library? The plays counter needs the same check. We don't have a 64,000-song test library yet.
>
> 1. **Time both features fairly** on your computer, at 500 to 4,000 songs, so one busy moment can't spoil the numbers.
> 2. **Name each one's growth rate** from your measurements.
> 3. **Predict the time** at a size you haven't run.

Two finished solutions from the music app are ready to race: **count plays**, which reads a playlist once to count how often a song appears, and **count repeats**, the report, which compares every song with every other song to count the pairs that share a title. You don't change them. You build the stopwatch that times them, keep the fastest of several runs, name each one's growth rate from your measurements, and use a growth rate to predict a time you haven't measured. There are five functions to finish:

- `timeTask` (`TimeTask` in C#, `time_task` in Python): run a task once and return how many milliseconds it took
- `fastest` (`Fastest`): the smallest time in a list
- `countPlaysRate` (`CountPlaysRate`, `count_plays_rate`): count plays' growth rate, such as `"O(n)"`
- `countRepeatsRate` (`CountRepeatsRate`, `count_repeats_rate`): count repeats' growth rate
- `predictTime` (`PredictTime`, `predict_time`): a task's time when its data grows a number of times, from its growth rate

## Pick your language

The same exercise is here in five languages. Work in the folder for the language you set up; you only need one.

| Folder | The solutions to race (ready) | Your code | The tests |
|---|---|---|---|
| `csharp/` | `RaceTwoSolutions/Given.cs` | `RaceTwoSolutions/Race.cs` | `RaceTwoSolutions.Tests/RaceTests.cs` |
| `java/` | `src/main/java/Given.java` | `src/main/java/Race.java` | `src/test/java/RaceTest.java` |
| `python/` | `given.py` | `race.py` | `test_race.py` |
| `javascript/` | `given.js` | `race.js` | `race.test.js` |
| `typescript/` | `given.ts` | `race.ts` | `race.test.ts` |

Each function returns `0` or empty text for now. The comment with it says what it should return, with examples. Replace the `return` line with your own code.

Every folder also has a demo program that races the two solutions at 500, 1,000, 2,000 and 4,000 songs and prints a table of times. Your times will be different from anyone else's (and from one run to the next): look at how they change from row to row. You don't need to change the tests, the demo or the solutions.

## Run it and check your work

Open your language's folder in VS Code (**File > Open Folder**), then open its terminal (**Terminal > New Terminal**) and run these commands there.

**C#**

```bash
dotnet run --project RaceTwoSolutions
dotnet test
```

**Java** (the Maven Wrapper downloads Maven the first time, so the first run takes a minute)

```bash
java src/main/java/Demo.java
./mvnw test
```

On Windows in PowerShell, write `.\mvnw test` instead of `./mvnw test`.

**Python** (once: make a virtual environment and install pytest into it)

```bash
python -m venv .venv
```

Then turn it on: `.venv\Scripts\Activate.ps1` in PowerShell on Windows, or `source .venv/bin/activate` on macOS (where the command is `python3`, not `python`). Then:

```bash
pip install -r requirements.txt
python demo.py
python -m pytest
```

**JavaScript**

```bash
node demo.js
npm test
```

**TypeScript** (once: `npm install`, which installs TypeScript)

```bash
node demo.ts
npm test
```

At first every test fails: that is expected. Each function you finish turns its tests green. A failing test's message starts with **Not yet:** and says what it expected.

<details>
<summary>Stuck?</summary>

- **Start with `timeTask` and `fastest`,** then run the demo: it shows your measurements, and they tell you the growth rates.
- **Read the clock before and after.** The time is the second reading minus the first, in milliseconds (Java's `System.nanoTime()` counts nanoseconds: divide by 1,000,000; Python's `time.perf_counter()` counts seconds: multiply by 1,000).
- **Name a growth rate from the ratios.** Divide each row's time by the row above: about 2 is O(n), about 4 is O(n²). The count plays times are tiny, so they're the noisiest; look at the overall trend.
- **Write the growth rates exactly** as `"O(1)"`, `"O(n)"` and `"O(n²)"`. If you can't type the small 2, `"O(n^2)"` works too. In Java, prefer `"O(n^2)"`: some Windows terminals show the small 2 as a question mark when Java prints it.

</details>

<details>
<summary>Why Should I Choose This?</summary>

Open this once your tests are green.

- **One run, read off the stopwatch:** a computer is always busy with something else, and the first run is often slower while the language gets ready. One run can be twice too slow, and product would plan around a number that was never true.
- **Counting steps without measuring:** counting predicts the growth rate, and it's right, but "is it really slow?" is a question about a real machine. The measurements show the same O(n) and O(n²) the step counts did.
- **Comparing your times with someone else's:** different computers give different numbers. The ratio when the data doubles, about 2 for O(n) and about 4 for O(n²), is the same on every computer, so that's what you report.
- **The fastest of five runs, at doubling sizes:** fair numbers, a growth rate read from the ratios, and a prediction anyone can check. What it can't promise: a prediction 16 times past your largest run assumes the growth rate holds that far. When the 64,000-song library exists, measure it.

</details>

## Hand it in

When it works, push your solution to a public repo of your own on GitHub, then paste that repo's address into **Submit your exercise** on the lesson page at [ask-codey.com](https://www.ask-codey.com). That's what completes the lesson. The lesson page shows the Git commands, step by step.
