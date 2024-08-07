public class BubbleSort {
    public static void main(String[] args) {
        // Initialize an array of integers to be sorted
        int[] arr = {5, 1, 4, 2, 8}; 
        
        // Call the bubbleSort method to sort the array
        bubbleSort(arr); 
        
        // Print the sorted array
        System.out.println("Sorted array: "); 
        for (int i : arr) { 
            System.out.print(i + " "); // Print each element of the sorted array
        }
    }

    // Method to perform Bubble Sort on an array
    public static void bubbleSort(int[] arr) {
        // Get the length of the array
        int n = arr.length; 
        
        // Declare a boolean flag to track if any elements were swapped during a pass
        boolean swapped; 
        
        // Outer loop for multiple passes through the array
        for (int i = 0; i < n - 1; i++) { 
            // Reset the swapped flag at the beginning of each pass
            swapped = false; 
            
            // Inner loop to compare adjacent elements
            for (int j = 0; j < n - 1 - i; j++) { 
                // Check if the current element is greater than the next element
                if (arr[j] > arr[j + 1]) { 
                    // Temporarily store the current element
                    int temp = arr[j]; 
                    
                    // Swap the current element with the next element
                    arr[j] = arr[j + 1]; 
                    
                    // Complete the swap by assigning the temporarily stored value
                    arr[j + 1] = temp; 
                    
                    // Set the swapped flag to true, indicating that a swap occurred
                    swapped = true; 
                }
            }
            
            // If no elements were swapped in the inner loop, the array is already sorted
            if (!swapped) break; 
        }
    }
}
