package Sorting;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class MergeSort {
    
    // Merge Sort for array
    public static <T extends Comparable<? super T>> void mergeSort(final T[] data, final Comparator<T> comparator) {
        if (data.length < 2) return; // Base case: Already sorted

        int mid = data.length / 2;
        T[] left = (T[]) new Comparable[mid];
        T[] right = (T[]) new Comparable[data.length - mid];

        // Split the array into left and right halves
        System.arraycopy(data, 0, left, 0, mid);
        System.arraycopy(data, mid, right, 0, data.length - mid);

        // Recursive calls
        mergeSort(left, comparator);
        mergeSort(right, comparator);

        // Merge sorted halves
        merge(data, left, right, comparator);
    }

    private static <T extends Comparable<? super T>> void merge(T[] data, T[] left, T[] right, Comparator<T> comparator) {
        int i = 0, j = 0, k = 0;

        // Merge two sorted halves into the main array
        while (i < left.length && j < right.length) {
            if (comparator.compare(left[i], right[j]) <= 0) {
                data[k++] = left[i++];
            } else {
                data[k++] = right[j++];
            }
        }

        // Copy any remaining elements from left
        while (i < left.length) {
            data[k++] = left[i++];
        }

        // Copy any remaining elements from right
        while (j < right.length) {
            data[k++] = right[j++];
        }
    }

    // Merge Sort for List
    public static <T extends Comparable<? super T>> void mergeSort(final List<T> data, final Comparator<T> comparator) {
        if (data.size() < 2) return;

        int mid = data.size() / 2;
        List<T> left = data.subList(0, mid);
        List<T> right = data.subList(mid, data.size());

        mergeSort(left, comparator);
        mergeSort(right, comparator);

        merge(data, left, right, comparator);
    }

    private static <T extends Comparable<? super T>> void merge(List<T> data, List<T> left, List<T> right, Comparator<T> comparator) {
        int i = 0, j = 0, k = 0;

        while (i < left.size() && j < right.size()) {
            if (comparator.compare(left.get(i), right.get(j)) <= 0) {
                data.set(k++, left.get(i++));
            } else {
                data.set(k++, right.get(j++));
            }
        }

        while (i < left.size()) {
            data.set(k++, left.get(i++));
        }

        while (j < right.size()) {
            data.set(k++, right.get(j++));
        }
    }

     public static void main(String[] args) {
        // Create a comparator for Integer objects
        Comparator<Integer> comparator = new Comparator<Integer>() {
            @Override
            public int compare(Integer a, Integer b) {
                return a.compareTo(b);
            }
        };

        // ===== Test Merge Sort on an array =====
        Integer[] mergeArray = {5, 2, 9, 1, 5, 6};
        System.out.println("Original Array for Merge Sort: " + Arrays.toString(mergeArray));
        MergeSort.mergeSort(mergeArray, comparator);
        System.out.println("Sorted Array using Merge Sort: " + Arrays.toString(mergeArray));

        // ===== Test Merge Sort on a list =====
        List<Integer> mergeList = new ArrayList<>(Arrays.asList(5, 2, 9, 1, 5, 6));
        System.out.println("Original List for Merge Sort: " + mergeList);
        MergeSort.mergeSort(mergeList, comparator);
        System.out.println("Sorted List using Merge Sort: " + mergeList);
    }
}