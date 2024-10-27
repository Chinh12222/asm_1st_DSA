import java.util.Arrays;
import java.util.Random;

public class Sorting {

    // Quick Sort implementation
    public static void quickSort(int[] arr, int low, int high) {
        if (low < high) {
            int pi = partition(arr, low, high);
            quickSort(arr, low, pi - 1);
            quickSort(arr, pi + 1, high);
        }
    }

    private static int partition(int[] arr, int low, int high) {
        int pivot = arr[high];
        int i = (low - 1);
        for (int j = low; j < high; j++) {
            if (arr[j] <= pivot) {
                i++;
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }
        }
        int temp = arr[i + 1];
        arr[i + 1] = arr[high];
        arr[high] = temp;
        return i + 1;
    }

    // Merge Sort implementation
    public static void mergeSort(int[] arr) {
        if (arr.length < 2) return;
        int mid = arr.length / 2;
        int[] left = Arrays.copyOfRange(arr, 0, mid);
        int[] right = Arrays.copyOfRange(arr, mid, arr.length);
        mergeSort(left);
        mergeSort(right);
        merge(arr, left, right);
    }

    private static void merge(int[] arr, int[] left, int[] right) {
        int i = 0, j = 0, k = 0;
        while (i < left.length && j < right.length) {
            if (left[i] <= right[j]) {
                arr[k++] = left[i++];
            } else {
                arr[k++] = right[j++];
            }
        }
        while (i < left.length) arr[k++] = left[i++];
        while (j < right.length) arr[k++] = right[j++];
    }

    public static void main(String[] args) {
        Random random = new Random();
        int size = 10000; // Number of items to sort
        int[] quickSortArray = random.ints(size, 0, 10000).toArray();
        int[] mergeSortArray = Arrays.copyOf(quickSortArray, quickSortArray.length);

        // Measure time for Quick Sort
        long startTime = System.nanoTime();
        quickSort(quickSortArray, 0, quickSortArray.length - 1);
        long endTime = System.nanoTime();
        System.out.println("Quick Sort Time: " + (endTime - startTime) + " ns");

        // Measure time for Merge Sort
        startTime = System.nanoTime();
        mergeSort(mergeSortArray);
        endTime = System.nanoTime();
        System.out.println("Merge Sort Time: " + (endTime - startTime) + " ns");
    }
}

