# The tests for your functions. You don't need to change this file.
# Each message says what was expected, so a failing test tells you what to look at.
import time

from race import count_repeats_rate, count_plays_rate, fastest, predict_time, time_task


def test_time_task_runs_the_task_exactly_once():
    runs = []
    time_task(lambda: runs.append(1))
    assert len(runs) == 1, "Not yet: time_task should run the task once, between reading the clock before and after."


def test_time_task_measures_a_twenty_millisecond_task():
    def wait():
        start = time.perf_counter()
        while time.perf_counter() - start < 0.020:
            pass

    measured = time_task(wait)
    assert 15 <= measured < 5000, f"Not yet: a task that takes 20 ms should measure about 20 ms, but time_task returned {measured}."


def test_fastest_picks_the_smallest_time():
    assert fastest([5.2, 3.1, 4.8]) == 3.1, "Not yet: the smallest of 5.2, 3.1 and 4.8 is 3.1."
    assert fastest([7.0]) == 7.0, "Not yet: one time is its own fastest: 7.0."


def test_count_plays_grows_linearly():
    assert count_plays_rate() == "O(n)", \
        "Not yet: count_plays reads every title once, so its time doubles when the songs double: O(n)."


def test_count_repeats_grows_quadratically():
    rate = count_repeats_rate()
    assert rate in ("O(n²)", "O(n^2)"), \
        f"Not yet: count_repeats compares every song with every other song, so its time grows about four times when the songs double: O(n²). It returned \"{rate}\"."


def test_predict_time_for_linear_grows_by_the_factor():
    assert predict_time(10, "O(n)", 2) == 20, "Not yet: O(n) work at 10 ms takes about 20 ms with twice the data."
    assert predict_time(10, "O(n)", 10) == 100, "Not yet: O(n) work at 10 ms takes about 100 ms with ten times the data."


def test_predict_time_for_quadratic_grows_by_the_factor_squared():
    assert predict_time(10, "O(n²)", 2) == 40, "Not yet: O(n²) work at 10 ms takes about 40 ms with twice the data."
    assert predict_time(10, "O(n^2)", 10) == 1000, "Not yet: O(n^2) work at 10 ms takes about 1,000 ms with ten times the data."


def test_predict_time_for_constant_stays_the_same():
    assert predict_time(10, "O(1)", 2) == 10, "Not yet: O(1) work takes the same 10 ms however much data there is."
    assert predict_time(10, "O(1)", 1000) == 10, "Not yet: O(1) work takes the same 10 ms even with a thousand times the data."
