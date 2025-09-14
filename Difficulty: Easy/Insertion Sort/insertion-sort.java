class Solution {
    // Please change the array in-place
    public void insertionSort(int arr[]) {
        // Traverse from 1 to length of the array
        for (int i = 1; i < arr.length; i++) {
            int curr = arr[i];   // element to be placed at correct position
            int prev = i - 1;

            // Shift elements of arr[0..i-1], that are greater than curr,
            // to one position ahead of their current position
            while (prev >= 0 && arr[prev] > curr) {
                arr[prev + 1] = arr[prev];
                prev--;
            }

            // Place the current element after the last shifted element
            arr[prev + 1] = curr;
        }
    }
}
