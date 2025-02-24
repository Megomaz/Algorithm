package Sorting;
import java.util.*;

public class Timer {
    // Constants for controlling the number of repetitions
    public static final int MIN_REPEATS = 10;
    public static final int MAX_REPEATS = 10000;
    public static final long MIN_SECONDS = (long) (3 * 1e9); // 3 seconds in nanoseconds

    /**
     * Measures the average execution time of a given task.
     *
     * @param worker A Runnable task to execute.
     * @return The average execution time in seconds.
     */
    public static double measure(Runnable worker) {
        long nRepeats = 0;
        long start = System.nanoTime();

        while (true) {
            worker.run();
            nRepeats++;

            // Stop if we've met the minimum and maximum repetitions or if time exceeded
            if ((nRepeats >= MIN_REPEATS && nRepeats <= MAX_REPEATS) ||
                (nRepeats % MIN_REPEATS == 0 && (System.nanoTime() - start) > MIN_SECONDS)) {
                break;
            }
        }

        long elapsed = System.nanoTime() - start;
        return (1e-9 * elapsed) / nRepeats; // Convert nanoseconds to seconds
    }

    public static void main(String[] args) {
        int nMin = 100, nMax = 100000, nSamples = 50;
        double alpha = ((Math.log(nMax) / Math.log(nMin)) - 1) / (nSamples - 1);

        for (int i = 0; i < nSamples; i++) {
            int n = (int) Math.pow(nMin, (1 + i * alpha));

            Runnable worker = () -> {
                int[] arr = new Random().ints(n).toArray();
                Arrays.sort(arr); // Using built-in sort for testing
            };

            double result = Timer.measure(worker);
            System.out.println(i + "\t" + n + "\t" + result);
        }
    }
}