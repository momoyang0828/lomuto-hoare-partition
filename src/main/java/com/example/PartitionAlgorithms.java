package com.example;

public final class PartitionAlgorithms {

    private PartitionAlgorithms() {}

    /**
     * Lomuto partition scheme.
     * Pivot chosen as arr[high].
     *
     * After partition:
     * - all elements <= pivot are on the left of returned index
     * - all elements  > pivot are on the right of returned index
     *
     * @return the final index of pivot
     */
    public static int lomutoPartition(int[] arr, int low, int high) {
        if (arr == null) {
            throw new IllegalArgumentException("arr cannot be null");
        }
        if (arr.length == 0) {
            return -1; // nothing to partition
        }
        if (low < 0 || high >= arr.length || low > high) {
            throw new IllegalArgumentException("Invalid low/high range");
        }

        int pivot = arr[high];
        int i = low - 1;

        for (int j = low; j <= high - 1; j++) {
            if (arr[j] <= pivot) {
                i++;
                swap(arr, i, j);
            }
        }
        swap(arr, i + 1, high);
        return i + 1;
    }

    /**
     * Hoare partition scheme.
     * Pivot chosen as arr[low].
     *
     * After partition:
     * - all elements in [low..p] <= pivot
     * - all elements in [p+1..high] >= pivot
     *
     * Note: returned index is a split point, not necessarily pivot's final position.
     *
     * @return split index p
     */
    public static int hoarePartition(int[] arr, int low, int high) {
        if (arr == null) {
            throw new IllegalArgumentException("arr cannot be null");
        }
        if (arr.length == 0) {
            return -1; // nothing to partition
        }
        if (low < 0 || high >= arr.length || low > high) {
            throw new IllegalArgumentException("Invalid low/high range");
        }

        int pivot = arr[low];
        int i = low - 1;
        int j = high + 1;

        while (true) {
            do {
                i++;
            } while (arr[i] < pivot);

            do {
                j--;
            } while (arr[j] > pivot);

            if (i >= j) {
                return j;
            }

            swap(arr, i, j);
        }
    }

    private static void swap(int[] arr, int a, int b) {
        if (a == b) return;
        int tmp = arr[a];
        arr[a] = arr[b];
        arr[b] = tmp;
    }
}
