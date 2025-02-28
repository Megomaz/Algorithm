package Searching;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class BinarySearch {
    
    // Iterative binary search implementation for arrays.
    public static <T extends Comparable<T>> int binarySearch(final T[] array, final T elem, final Comparator<T> comparator) {
        int left = 0, right = array.length - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            int cmp = comparator.compare(array[mid], elem);
            if (cmp == 0) return mid;
            if (cmp < 0) left = mid + 1;
            else right = mid - 1;
        }
        return -1;
    }

    // Recursive binary search implementation for arrays.
    public static <T extends Comparable<T>> int binarySearchRecursive(final T[] array, final T elem, final Comparator<T> comparator) {
        return binarySearchRecursiveHelper(array, elem, comparator, 0, array.length - 1);
    }

    // Helper function for recursive binary search.
    private static <T extends Comparable<T>> int binarySearchRecursiveHelper(final T[] array, final T elem, final Comparator<T> comparator, int left, int right) {
        if (left > right) return -1;
        int mid = left + (right - left) / 2;
        int cmp = comparator.compare(array[mid], elem);
        if (cmp == 0) return mid;
        if (cmp < 0) return binarySearchRecursiveHelper(array, elem, comparator, mid + 1, right);
        else return binarySearchRecursiveHelper(array, elem, comparator, left, mid - 1);
    }

    // Iterative binary search implementation for lists.
    public static <T extends Comparable<T>> int binarySearch(final List<T> list, final T elem, final Comparator<T> comparator) {
        int left = 0, right = list.size() - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            int cmp = comparator.compare(list.get(mid), elem);
            if (cmp == 0) return mid;
            if (cmp < 0) left = mid + 1;
            else right = mid - 1;
        }
        return -1;
    }

    // Main method to test binary search implementations.
    public static void main(String[] args) {
        Integer[] array = {1, 3, 5, 7, 9, 11, 13, 21};
        List<Integer> list = Arrays.asList(array);
        int target = 5;

        Comparator<Integer> comparator = Integer::compareTo;

        System.out.println("Binary Search (Array): " + binarySearch(array, target, comparator));
        System.out.println("Binary Search Recursive (Array): " + binarySearchRecursive(array, target, comparator));
        System.out.println("Binary Search (List): " + binarySearch(list, target, comparator));
    }
}
