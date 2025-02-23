import java.util.*;

public class SelectionSort {
    
    // For List-based sorting
    public static <T extends Comparable<T>> void selectionSort(final List<T> input, final Comparator<T> comparator) {
        int n = input.size();
        for (int i = 0; i < n - 1; i++) {
            int minIndex = i;

            for (int j = i + 1; j < n; j++) {
                if (comparator.compare(input.get(j), input.get(minIndex)) < 0) {
                    minIndex = j;
                }
            }

            Collections.swap(input, i, minIndex);
        }
    }

    // For Array-based sorting
    public static <T extends Comparable<T>> void selectionSort(final T[] input, final Comparator<T> comparator) {
        int n = input.length;
        for (int i = 0; i < n - 1; i++) {
            int minIndex = i;

            for (int j = i + 1; j < n; j++) {
                if (comparator.compare(input[j], input[minIndex]) < 0) {
                    minIndex = j;
                }
            }

            T temp = input[i];
            input[i] = input[minIndex];
            input[minIndex] = temp;
        }
    }

    public static void main(String[] args) {
        Random random = new Random();

        // Generate a list with 10,000 random integers
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < 10000; i++) {
            list.add(random.nextInt(100000)); // Random values between 0 and 99,999
        }

        // Generate an array with 10,000 random integers
        Integer[] array = new Integer[10000];
        for (int i = 0; i < 10000; i++) {
            array[i] = random.nextInt(100000);
        }

        // Define a comparator for sorting
        Comparator<Integer> comparator = Integer::compareTo;

        // Call sorting methods
        SelectionSort.selectionSort(list, comparator);
        SelectionSort.selectionSort(array, comparator);

        // Print first 10 elements as a sample
        System.out.println("Sorted list sample: " + list.subList(0, 10));
        System.out.println("Sorted array sample: " + Arrays.toString(Arrays.copyOfRange(array, 0, 10)));
    }
}