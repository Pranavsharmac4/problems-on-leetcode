public class MergeSort {

    /**
     * Main method to initiate merge sort
     * Time Complexity: O(n log n) in all cases
     * Space Complexity: O(n) for temporary arrays
     */
    public static void mergeSort(int[] arr) {
        if (arr == null || arr.length == 0) {
            return;
        }
        mergeSort(arr, 0, arr.length - 1);
    }

    /**
     * Recursive divide-and-conquer helper method
     * Divides array into halves until single elements remain
     */
    private static void mergeSort(int[] arr, int left, int right) {
        if (left < right) {
            // Find middle point to divide array into two halves
            int mid = left + (right - left) / 2;

            // Sort left half
            mergeSort(arr, left, mid);

            // Sort right half
            mergeSort(arr, mid + 1, right);

            // Merge the sorted halves
            merge(arr, left, mid, right);
        }
    }

    /**
     * Merge two sorted subarrays into one sorted array
     * Left subarray: arr[left..mid]
     * Right subarray: arr[mid+1..right]
     */
    private static void merge(int[] arr, int left, int mid, int right) {
        // Create temporary arrays
        int[] leftArr = new int[mid - left + 1];
        int[] rightArr = new int[right - mid];

        // Copy data to temporary arrays
        for (int i = 0; i < leftArr.length; i++) {
            leftArr[i] = arr[left + i];
        }
        for (int i = 0; i < rightArr.length; i++) {
            rightArr[i] = arr[mid + 1 + i];
        }

        // Merge the temporary arrays back into arr[left..right]
        int i = 0;      // Pointer for left subarray
        int j = 0;      // Pointer for right subarray
        int k = left;   // Pointer for main array

        while (i < leftArr.length && j < rightArr.length) {
            if (leftArr[i] <= rightArr[j]) {
                arr[k++] = leftArr[i++];
            } else {
                arr[k++] = rightArr[j++];
            }
        }

        // Copy remaining elements from left subarray
        while (i < leftArr.length) {
            arr[k++] = leftArr[i++];
        }

        // Copy remaining elements from right subarray
        while (j < rightArr.length) {
            arr[k++] = rightArr[j++];
        }
    }

    /**
     * Utility method to print array
     */
    public static void printArray(int[] arr) {
        for (int num : arr) {
            System.out.print(num + " ");
        }
        System.out.println();
    }

    /**
     * Main method with test cases
     */
    public static void main(String[] args) {
        // Test case 1: Unsorted array
        int[] arr1 = {64, 34, 25, 12, 22, 11, 90};
        System.out.println("Original array:");
        printArray(arr1);
        mergeSort(arr1);
        System.out.println("Sorted array:");
        printArray(arr1);

        System.out.println();

        // Test case 2: Already sorted array
        int[] arr2 = {1, 2, 3, 4, 5};
        System.out.println("Already sorted array:");
        printArray(arr2);
        mergeSort(arr2);
        System.out.println("After merge sort:");
        printArray(arr2);

        System.out.println();

        // Test case 3: Reverse sorted array
        int[] arr3 = {9, 8, 7, 6, 5, 4, 3, 2, 1};
        System.out.println("Reverse sorted array:");
        printArray(arr3);
        mergeSort(arr3);
        System.out.println("After merge sort:");
        printArray(arr3);

        System.out.println();

        // Test case 4: Array with duplicates
        int[] arr4 = {5, 2, 8, 2, 9, 1, 5, 5};
        System.out.println("Array with duplicates:");
        printArray(arr4);
        mergeSort(arr4);
        System.out.println("After merge sort:");
        printArray(arr4);

        System.out.println();

        // Test case 5: Single element array
        int[] arr5 = {42};
        System.out.println("Single element array:");
        printArray(arr5);
        mergeSort(arr5);
        System.out.println("After merge sort:");
        printArray(arr5);
    }
}