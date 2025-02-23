import java.util.*;

public class BubbleSort {

    // For List-based sorting
    public static <T extends Comparable<T>> void bubbleSort(final List<T> input, final Comparator<T> comparator) {
        int n = input.size();
        for (int i = 0; i < n - 1; i++) {
            boolean swapped = false;
            for (int j = 0; j < n - 1 - i; j++) {
                if (comparator.compare(input.get(j), input.get(j + 1)) > 0) {
                    Collections.swap(input, j, j + 1);
                    swapped = true;
                }
            }
            if (!swapped) break; 
        }
    }

    // For Array-based sorting
    public static <T extends Comparable<T>> void bubbleSort(final T[] input, final Comparator<T> comparator) {
        int n = input.length;
        for (int i = 0; i < n - 1; i++) {
            boolean swapped = false;
            for (int j = 0; j < n - 1 - i; j++) {
                if (comparator.compare(input[j], input[j + 1]) > 0) {
                    T temp = input[j];
                    input[j] = input[j + 1];
                    input[j + 1] = temp;
                    swapped = true;
                }
            }
            if (!swapped) break; 
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
        BubbleSort.bubbleSort(list, comparator);
        BubbleSort.bubbleSort(array, comparator);

        // Print first 10 elements as a sample
        System.out.println("Sorted list sample: " + list.subList(0, 10));
        System.out.println("Sorted array sample: " + Arrays.toString(Arrays.copyOfRange(array, 0, 10)));
        
    }
}