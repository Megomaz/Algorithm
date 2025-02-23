import java.util.*;

public class InsertionSort {
    // For List-based sorting
    public static <T extends Comparable<T>> void insertionSort(final List<T> input, final Comparator<T> comparator) {
        int n = input.size();
        for (int i = 1; i < n; i++) {
            T temp = input.get(i);
            int j = i - 1;

            while (j >= 0 && comparator.compare(input.get(j), temp) > 0) {
                input.set(j + 1, input.get(j));
                j--;
            }
            input.set(j + 1, temp);
        }

    }

    // For Array-based sorting
    public static <T extends Comparable<T>> void insertionSort(final T[] input, final Comparator<T> comparator) {
        int n = input.length;
        for (int i = 1; i < n; i++) {
            T temp = input[i];
            int j = i - 1;

            while (j >= 0 && comparator.compare(input[j], temp) > 0) {
                input[j + 1] = input[j];
                j--;
            }
            input[j + 1] = temp;
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
        InsertionSort.insertionSort(list, comparator);
        InsertionSort.insertionSort(array, comparator);

        // Print first 10 elements as a sample
        System.out.println("Sorted list sample: " + list.subList(0, 10));
        System.out.println("Sorted array sample: " + Arrays.toString(Arrays.copyOfRange(array, 0, 10)));
        

    }
    
}