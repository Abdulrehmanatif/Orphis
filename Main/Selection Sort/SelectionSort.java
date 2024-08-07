public class SelectionSort {
    // Method to perform selection sort
    public static void selectionSort(int[] arr) {
        int n = arr.length; // Get the length of the array

        // Iterate over each element in the array except the last one
        for (int i = 0; i < n - 1; i++) {
            // Assume the current element is the minimum
            int minIndex = i;
            
            // Iterate over the unsorted part of the array
            for (int j = i + 1; j < n; j++) {
                // Update minIndex if a smaller element is found
                if (arr[j] < arr[minIndex]) {
                    minIndex = j;
                }
            }

            // Swap the found minimum element with the first element of the unsorted part
            int temp = arr[minIndex];
            arr[minIndex] = arr[i];
            arr[i] = temp;
        }
    }

    public static void main(String[] args) {
        // Define an array to be sorted
        int[] arr = {64, 25, 12, 22, 11};

        // Print the original array
        System.out.println("Original array:");
        for (int i : arr) {
            System.out.print(i + " ");
        }

        // Call the selectionSort method to sort the array
        selectionSort(arr);

        // Print the sorted array
        System.out.println("\nSorted array:");
        for (int i : arr) {
            System.out.print(i + " ");
        }
    }
}
