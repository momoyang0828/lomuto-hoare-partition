package com.example;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class PartitionAlgorithmsTest {

    // ====== Teacher required arrays ======
    private static final int[] SORTED = {10, 17, 19, 21, 44, 55, 57, 63, 65, 67};
    private static final int[] EMPTY = {};
    private static final int[] UNSORTED = {84, 3, 7, 1, 9, 6, 2, 5};

    // ---------- Lomuto tests ----------
    @Test
    void lomuto_partition_sortedArray_shouldRespectPartitionProperty() {
        int[] arr = SORTED.clone();
        int low = 0, high = arr.length - 1;

        int pivotValue = arr[high]; // Lomuto pivot = arr[high]
        int p = PartitionAlgorithms.lomutoPartition(arr, low, high);

        assertTrue(p >= low && p <= high, "Returned pivot index should be within [low, high]");
        assertEquals(pivotValue, arr[p], "Pivot should end up at returned index");

        // Left side <= pivot, right side > pivot (as implemented)
        for (int i = low; i < p; i++) {
            assertTrue(arr[i] <= pivotValue, "Left side must be <= pivot");
        }
        for (int i = p + 1; i <= high; i++) {
            assertTrue(arr[i] > pivotValue, "Right side must be > pivot");
        }
    }

    @Test
    void lomuto_partition_unsortedArray_shouldRespectPartitionProperty() {
        int[] arr = UNSORTED.clone();
        int low = 0, high = arr.length - 1;

        int pivotValue = arr[high];
        int p = PartitionAlgorithms.lomutoPartition(arr, low, high);

        assertTrue(p >= low && p <= high);
        assertEquals(pivotValue, arr[p]);

        for (int i = low; i < p; i++) {
            assertTrue(arr[i] <= pivotValue);
        }
        for (int i = p + 1; i <= high; i++) {
            assertTrue(arr[i] > pivotValue);
        }
    }

    @Test
    void lomuto_partition_emptyArray_shouldReturnMinus1AndNotCrash() {
        int[] arr = EMPTY.clone();
        int p = PartitionAlgorithms.lomutoPartition(arr, 0, 0);
        assertEquals(-1, p);
        assertArrayEquals(new int[]{}, arr);
    }

    // ---------- Hoare tests ----------
    @Test
    void hoare_partition_sortedArray_shouldRespectPartitionProperty() {
        int[] arr = SORTED.clone();
        int low = 0, high = arr.length - 1;

        int pivotValue = arr[low]; // Hoare pivot = arr[low]
        int p = PartitionAlgorithms.hoarePartition(arr, low, high);

        assertTrue(p >= low && p <= high, "Split index should be within [low, high]");

        // Hoare: [low..p] <= pivot, [p+1..high] >= pivot
        for (int i = low; i <= p; i++) {
            assertTrue(arr[i] <= pivotValue, "Left side must be <= pivot");
        }
        for (int i = p + 1; i <= high; i++) {
            assertTrue(arr[i] >= pivotValue, "Right side must be >= pivot");
        }
    }

    @Test
    void hoare_partition_unsortedArray_shouldRespectPartitionProperty() {
        int[] arr = UNSORTED.clone();
        int low = 0, high = arr.length - 1;

        int pivotValue = arr[low];
        int p = PartitionAlgorithms.hoarePartition(arr, low, high);

        assertTrue(p >= low && p <= high);

        for (int i = low; i <= p; i++) {
            assertTrue(arr[i] <= pivotValue);
        }
        for (int i = p + 1; i <= high; i++) {
            assertTrue(arr[i] >= pivotValue);
        }
    }

    @Test
    void hoare_partition_emptyArray_shouldReturnMinus1AndNotCrash() {
        int[] arr = EMPTY.clone();
        int p = PartitionAlgorithms.hoarePartition(arr, 0, 0);
        assertEquals(-1, p);
        assertArrayEquals(new int[]{}, arr);
    }
}
