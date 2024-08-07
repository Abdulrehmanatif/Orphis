here's a breakdown of the Bubble Sort implementation in Java:

```java
public class BubbleSort {
    public static void main(String[] args) {
        int[] arr = {5, 1, 4, 2, 8}; // Initial array to be sorted
        bubbleSort(arr); // Calling the bubbleSort method to sort the array
        System.out.println("Sorted array: ");
        for (int i : arr) { // Printing the sorted array
            System.out.print(i + " ");
        }
    }

    // Method to perform Bubble Sort on an array
    public static void bubbleSort(int[] arr) {
        int n = arr.length; // Length of the array
        boolean swapped; // Flag to check if any swapping happened
        for (int i = 0; i < n - 1; i++) { // Outer loop: Number of passes
            swapped = false; // Reset swapped flag at the beginning of each pass
            for (int j = 0; j < n - 1 - i; j++) { // Inner loop: Traverse the array
                if (arr[j] > arr[j + 1]) { // Compare adjacent elements
                    int temp = arr[j]; // Swap if elements are in the wrong order
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                    swapped = true; // Set swapped flag to true
                }
            }
            if (!swapped) break; // If no elements were swapped, the array is already sorted
        }
    }
}
```
### Explanation:

1. **Main Method**:
   - `int[] arr = {5, 1, 4, 2, 8};`: Initializes an array of integers to be sorted.
   - `bubbleSort(arr);`: Calls the `bubbleSort` method to sort the array.
   - `System.out.println("Sorted array: ");`: Prints the label for the sorted array.
   - `for (int i : arr) { System.out.print(i + " "); }`: Iterates through the sorted array and prints each element.

2. **bubbleSort Method**:
   - `int n = arr.length;`: Gets the length of the array.
   - `boolean swapped;`: Declares a boolean flag to track if any elements were swapped during a pass.
   - `for (int i = 0; i < n - 1; i++)`: Outer loop for multiple passes through the array.
     - `swapped = false;`: Resets the swapped flag at the beginning of each pass.
     - `for (int j = 0; j < n - 1 - i; j++)`: Inner loop to compare adjacent elements. The `n - 1 - i` part ensures that the largest elements bubble to the end and are not re-checked in subsequent passes.
       - `if (arr[j] > arr[j + 1])`: Checks if the current element is greater than the next element.
         - `int temp = arr[j];`: Temporarily stores the current element.
         - `arr[j] = arr[j + 1];`: Swaps the current element with the next element.
         - `arr[j + 1] = temp;`: Completes the swap by assigning the temporarily stored value.
         - `swapped = true;`: Sets the swapped flag to true, indicating that a swap occurred.
     - `if (!swapped) break;`: If no elements were swapped in the inner loop, the array is already sorted, and the outer loop can be terminated early.