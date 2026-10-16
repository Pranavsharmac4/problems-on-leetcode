class Solution {
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
    public int[] sortArray(int[] nums){
       mergeSort(nums);
       return nums;
    }
}