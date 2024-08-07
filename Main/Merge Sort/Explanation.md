Here’s a detailed explanation of the merge sort algorithm implemented in the provided Java code:

### 1. Main Method
```java
public static void main(String[] args) {
    int[] array = {38, 27, 43, 3, 9, 82, 10}; // Sample array
    mergeSort(array, 0, array.length - 1); // Call merge sort on the entire array
    for (int num : array) {
        System.out.print(num + " "); // Print sorted array
    }
}
```
- **`int[] array`**: Defines an array with sample values.
- **`mergeSort(array, 0, array.length - 1)`**: Calls the `mergeSort` method to sort the entire array. Here, `0` is the starting index, and `array.length - 1` is the ending index.
- **`for (int num : array)`**: Iterates through the sorted array and prints each element.

### 2. Merge Sort Function
```java
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
```
- **`if (left < right)`**: Base condition to ensure that the array has more than one element to sort.
- **`int mid = (left + right) / 2`**: Calculates the middle index of the array segment.
- **`mergeSort(array, left, mid)`**: Recursively sorts the left half of the array.
- **`mergeSort(array, mid + 1, right)`**: Recursively sorts the right half of the array.
- **`merge(array, left, mid, right)`**: Merges the two sorted halves.

### 3. Merge Function
```java
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
```
- **`int n1 = mid - left + 1`**: Calculates the size of the left subarray.
- **`int n2 = right - mid`**: Calculates the size of the right subarray.
- **`int[] leftArray = new int[n1]`** and **`int[] rightArray = new int[n2]`**: Create temporary arrays to hold the values of the left and right subarrays.
- **`for (int i = 0; i < n1; i++)`** and **`for (int j = 0; j < n2; j++)`**: Copy the values from the original array into the temporary arrays.
- **`while (i < n1 && j < n2)`**: Merges the temporary arrays back into the original array by comparing elements from the two arrays and placing them in the correct order.
- **`while (i < n1)`**: Copies any remaining elements from the left array if there are any left after merging.
- **`while (j < n2)`**: Copies any remaining elements from the right array if there are any left after merging.

The `mergeSort` function recursively divides the array into smaller subarrays until each subarray contains a single element, and then the `merge` function combines these subarrays in sorted order.