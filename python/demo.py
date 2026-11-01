# Races the two given solutions at four sizes. Run it with: python demo.py
# Your times will be different from anyone else's: look at how they change from row to row.
from given import count_repeats, count_plays
from race import count_repeats_rate, count_plays_rate, fastest, predict_time, time_task

last_pairs = 0
print("Songs   count plays (ms)   count repeats (ms)")
for songs in [500, 1000, 2000, 4000]:
    playlist = [f"Song {number}" for number in range(songs)]
    plays_times = []
    pairs_times = []
    for run in range(5):
        plays_times.append(time_task(lambda: count_plays(playlist, "Golden Hour")))
        pairs_times.append(time_task(lambda: count_repeats(playlist)))
    last_pairs = fastest(pairs_times)
    print(f"{songs}   {fastest(plays_times):.3f}   {last_pairs:.3f}")
print(f"count plays grows like {count_plays_rate()}; count repeats grows like {count_repeats_rate()}")
print(f"Predicted count repeats time for 8000 songs: {predict_time(last_pairs, count_repeats_rate(), 2):.3f} ms")
