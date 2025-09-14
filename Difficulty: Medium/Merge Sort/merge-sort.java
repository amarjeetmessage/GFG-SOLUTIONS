class Solution {

    // Function to perform Merge Sort
    void mergeSort(int arr[], int l, int r) {
        if (l >= r) {
            return; // base case
        }

        int mid = l + (r - l) / 2;

        // Recursively divide left and right halves
        mergeSort(arr, l, mid);
        mergeSort(arr, mid + 1, r);

        // Merge the two sorted halves
        merge(arr, l, mid, r);
    }

    // Function to merge two sorted subarrays
    void merge(int arr[], int l, int mid, int r) {
        // Sizes of two subarrays
        int n1 = mid - l + 1;
        int n2 = r - mid;

        // Temporary arrays
        int left[] = new int[n1];
        int right[] = new int[n2];

        // Copy data
        for (int i = 0; i < n1; i++) {
            left[i] = arr[l + i];
        }
        for (int j = 0; j < n2; j++) {
            right[j] = arr[mid + 1 + j];
        }

        // Merge process
        int i = 0, j = 0, k = l;

        while (i < n1 && j < n2) {
            if (left[i] <= right[j]) {
                arr[k] = left[i];
                i++;
            } else {
                arr[k] = right[j];
                j++;
            }
            k++;
        }

        // Copy remaining elements (if any)
        while (i < n1) {
            arr[k] = left[i];
            i++;
            k++;
        }
        while (j < n2) {
            arr[k] = right[j];
            j++;
            k++;
        }
    }
}
