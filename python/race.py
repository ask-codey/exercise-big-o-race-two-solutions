# Your five functions. The comment under each one says what it should
# return, with examples. Replace each return line with your own code.
import time


def time_task(task):
    """
    Run the task once and return how many milliseconds it took, using
    time.perf_counter() before and after (seconds: multiply by 1000).

    time_task(lambda: count_repeats(playlist)) -> about 150 (it depends on your computer)
    """
    return 0


def fastest(times):
    """
    The smallest time in the list: the run with the fewest interruptions.

    fastest([5.2, 3.1, 4.8]) -> 3.1
    """
    return 0


def count_plays_rate():
    """
    The growth rate of given.count_plays, as "O(1)", "O(n)" or "O(n²)".
    Time it at a size and at double that size (the demo does this),
    or count its loops.
    """
    return ""


def count_repeats_rate():
    """
    The growth rate of given.count_repeats, as "O(1)", "O(n)" or "O(n²)"
    ("O(n^2)" is fine too, if you can't type the small 2).
    """
    return ""


def predict_time(milliseconds, growth_rate, factor):
    """
    Predict a task's time when its data grows `factor` times, from its
    time now and its growth rate: O(1) stays the same, O(n) grows by the
    factor, O(n²) (or "O(n^2)") by the factor times itself.

    predict_time(10, "O(n)", 2) -> 20
    predict_time(10, "O(n²)", 2) -> 40
    predict_time(10, "O(1)", 2) -> 10
    """
    return 0
