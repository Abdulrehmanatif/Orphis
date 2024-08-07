public class MergeSort {

    // Main method to run the merge sort
    public static void main(String[] args) {
        int[] array = {38, 27, 43, 3, 9, 82, 10}; // Sample array
        mergeSort(array, 0, array.length - 1); // Call merge sort on the entire array
        for (int num : array) {
            System.out.print(num + " "); // Print sorted array
        }
    }

    // Merge sort function
    public static void mergeSort(int[] array, int left, int right) {
        if (left < right) {
            int mid = (left + right) / 2; // Find the middle point

            // Recursively sort the first half
            mergeSort(array, left, mid);
            // Recursively sort the second half
            mergeSort(array, mid + 1, right);

            // Merge the sorted halves
            merge(array, left, mid, right);
        }
    }

    // Merge function to combine two sorted subarrays
    public static void merge(int[] array, int left, int mid, int right) {
        // Find sizes of the two subarrays to be merged
        int n1 = mid - left + 1;
        int n2 = right - mid;

        // Create temporary arrays
        int[] leftArray = new int[n1];
        int[] rightArray = new int[n2];

        // Copy data to temporary arrays
        for (int i = 0; i < n1; i++) {
            leftArray[i] = array[left + i];
        }
        for (int j = 0; j < n2; j++) {
            rightArray[j] = array[mid + 1 + j];
        }

        // Initial indexes for left, right and merged subarrays
        int i = 0, j = 0, k = left;

        // Merge the temporary arrays back into the original array
        while (i < n1 && j < n2) {
            if (leftArray[i] <= rightArray[j]) {
                array[k] = leftArray[i];
                i++;
            } else {
                array[k] = rightArray[j];
                j++;
            }
            k++;
        }

        // Copy remaining elements of leftArray[] if any
        while (i < n1) {
            array[k] = leftArray[i];
            i++;
            k++;
        }

        // Copy remaining elements of rightArray[] if any
        while (j < n2) {
            array[k] = rightArray[j];
            j++;
            k++;
        }
    }
}
