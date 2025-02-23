package Sorting;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class QuickSort {
    
    // Quick Sort for array
    public static <T extends Comparable<? super T>> void quickSort(final T[] data, final Comparator<T> comparator) {
        quickSortHelper(data, 0, data.length - 1, comparator);
    }

    private static <T extends Comparable<? super T>> void quickSortHelper(T[] data, int low, int high, Comparator<T> comparator) {
        if (low < high) {
            int pivotIndex = partition(data, low, high, comparator);
            quickSortHelper(data, low, pivotIndex - 1, comparator);
            quickSortHelper(data, pivotIndex + 1, high, comparator);
        }
    }

    private static <T extends Comparable<? super T>> int partition(T[] data, int low, int high, Comparator<T> comparator) {
        T pivot = data[high]; // Choose the last element as pivot
        int i = low - 1; // Pointer for smaller element

        for (int j = low; j < high; j++) {
            if (comparator.compare(data[j], pivot) <= 0) {
                i++;
                swap(data, i, j);
            }
        }
        swap(data, i + 1, high);
        return i + 1;
    }

    private static <T> void swap(T[] data, int i, int j) {
        T temp = data[i];
        data[i] = data[j];
        data[j] = temp;
    }

    // Quick Sort for List
    public static <T extends Comparable<? super T>> void quickSort(final List<T> data, final Comparator<T> comparator) {
        quickSortHelper(data, 0, data.size() - 1, comparator);
    }

    private static <T extends Comparable<? super T>> void quickSortHelper(List<T> data, int low, int high, Comparator<T> comparator) {
        if (low < high) {
            int pivotIndex = partition(data, low, high, comparator);
            quickSortHelper(data, low, pivotIndex - 1, comparator);
            quickSortHelper(data, pivotIndex + 1, high, comparator);
        }
    }

    private static <T extends Comparable<? super T>> int partition(List<T> data, int low, int high, Comparator<T> comparator) {
        T pivot = data.get(high);
        int i = low - 1;

        for (int j = low; j < high; j++) {
            if (comparator.compare(data.get(j), pivot) <= 0) {
                i++;
                swap(data, i, j);
            }
        }
        swap(data, i + 1, high);
        return i + 1;
    }

    private static <T> void swap(List<T> data, int i, int j) {
        T temp = data.get(i);
        data.set(i, data.get(j));
        data.set(j, temp);
    }

    public static void main(String[] args) {
        // Create a comparator for Integer objects
        Comparator<Integer> comparator = new Comparator<Integer>() {
            @Override
            public int compare(Integer a, Integer b) {
                return a.compareTo(b);
            }
        };

        // ===== Test Quick Sort on an array =====
        Integer[] quickArray = {8, 3, 7, 4, 2, 1};
        System.out.println("Original Array for Quick Sort: " + Arrays.toString(quickArray));
        QuickSort.quickSort(quickArray, comparator);
        System.out.println("Sorted Array using Quick Sort: " + Arrays.toString(quickArray));

        // ===== Test Quick Sort on a list =====
        List<Integer> quickList = new ArrayList<>(Arrays.asList(8, 3, 7, 4, 2, 1));
        System.out.println("Original List for Quick Sort: " + quickList);
        QuickSort.quickSort(quickList, comparator);
        System.out.println("Sorted List using Quick Sort: " + quickList);
    }
}