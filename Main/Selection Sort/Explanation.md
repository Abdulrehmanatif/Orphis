Here's a detailed explanation of each step in the selection sort algorithm implemented in Java:

1. **Define the SelectionSort class and the selectionSort method**:
   ```java
   public class SelectionSort {
       public static void selectionSort(int[] arr) {
           int n = arr.length;
   ```

   - `SelectionSort` is the class that contains the sorting logic.
   - `selectionSort` is a static method that takes an integer array `arr` as its parameter.
   - `n` stores the length of the array.

2. **Outer loop to iterate through the array**:
   ```java
           for (int i = 0; i < n - 1; i++) {
   ```

   - The outer loop runs from the first element to the second-to-last element of the array.
   - `i` represents the starting index of the unsorted portion of the array.

3. **Assume the current element is the minimum**:
   ```java
               int minIndex = i;
   ```

   - `minIndex` initially points to the current position `i`.

4. **Inner loop to find the minimum element in the unsorted portion**:
   ```java
               for (int j = i + 1; j < n; j++) {
                   if (arr[j] < arr[minIndex]) {
                       minIndex = j;
                   }
               }
   ```

   - The inner loop starts from the next element after `i` and goes to the end of the array.
   - If an element smaller than the current minimum (`arr[minIndex]`) is found, `minIndex` is updated to the index of that element.

5. **Swap the minimum element with the first element of the unsorted portion**:
   ```java
               int temp = arr[minIndex];
               arr[minIndex] = arr[i];
               arr[i] = temp;
           }
       }
   ```

   - A temporary variable `temp` is used to store the value at `minIndex`.
   - The value at `minIndex` is swapped with the value at the current position `i`.
   - This places the smallest element of the unsorted portion at the beginning, effectively growing the sorted portion of the array.

6. **Main method to test the selection sort**:
   ```java
       public static void main(String[] args) {
           int[] arr = {64, 25, 12, 22, 11};
           System.out.println("Original array:");
           for (int i : arr) {
               System.out.print(i + " ");
           }

           selectionSort(arr);

           System.out.println("\nSorted array:");
           for (int i : arr) {
               System.out.print(i + " ");
           }
       }
   }
   ```

   - An array `arr` is defined and initialized with unsorted elements.
   - The original array is printed.
   - `selectionSort` is called to sort the array.
   - The sorted array is printed.