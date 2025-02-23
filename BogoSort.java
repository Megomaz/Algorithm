import java.util.*;

public class BogoSort {

    // For List-based sorting
    private static final Random rand = new Random();
    
    public static <T extends Comparable<T>> void bogoSortList(final List<T> input, final Comparator<T> comparator) {
        while (!isSortedList(input, comparator)) {
            Collections.shuffle(input, rand); 
        }
    }

    private static <T> boolean isSortedList(List<T> list, Comparator<T> comparator) {
        for (int i = 0; i < list.size() - 1; i++) {
            if (comparator.compare(list.get(i), list.get(i + 1)) > 0) {
                return false;
            }
        }
        return true;
    }

    // For Array-based sorting
    public static <T extends Comparable<T>> void bogoSortArray(final T[] input, final Comparator<T> comparator) {
        while (!isSortedArray(input, comparator)) {
            shuffle(input, rand); 
        }
    }

    private static <T> boolean isSortedArray(T[] array, Comparator<T> comparator) {
        for (int i = 0; i < array.length - 1; i++) {
            if (comparator.compare(array[i], array[i + 1]) > 0) {
                return false;
            }
        }
        return true;
    }

    private static <T> void shuffle(T[] array, Random rand) {
        for (int i = array.length - 1; i > 0; i--) {
            int j = rand.nextInt(i + 1);
            T temp = array[i];
            array[i] = array[j];
            array[j] = temp;
        }
    }

    public static void main(String[] args) {
        // Testing BogoSort with List
        List<Integer> numbersList = Arrays.asList(3, 1, 4, 2);
        Comparator<Integer> comparatorList = Integer::compare;

        bogoSortList(numbersList, comparatorList);
        System.out.println("Sorted List: " + numbersList); 

        List<Double> doubleNumbersList = Arrays.asList(7.35, 1.43, 14.94, 5.72);
        Comparator<Double> doubleComparatorList = Double::compare;

        bogoSortList(doubleNumbersList, doubleComparatorList);
        System.out.println("Sorted Double List: " + doubleNumbersList);

        // Testing BogoSort with Array
        Integer[] numbersArray = {3, 1, 4, 2};
        Comparator<Integer> comparatorArray = Integer::compare;

        bogoSortArray(numbersArray, comparatorArray);
        System.out.println("Sorted Array: " + Arrays.toString(numbersArray)); 
    }
}