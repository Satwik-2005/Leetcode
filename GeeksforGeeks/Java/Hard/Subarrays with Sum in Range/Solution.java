class Solution {

    public int countSubarray(int[] arr, int l, int r) {

        int n = arr.length;

        long[] prefix = new long[n + 1];

        for (int i = 0; i < n; i++)
            prefix[i + 1] = prefix[i] + arr[i];

        return (int) mergeSort(prefix, 0, n, l, r);
    }

    private long mergeSort(long[] prefix, int low, int high, int lower, int upper) {

        if (low >= high)
            return 0;

        int mid = low + (high - low) / 2;

        long count = 0;

        count += mergeSort(prefix, low, mid, lower, upper);
        count += mergeSort(prefix, mid + 1, high, lower, upper);

        int start = mid + 1;
        int end = mid + 1;

        for (int i = low; i <= mid; i++) {

            while (start <= high && prefix[start] - prefix[i] < lower)
                start++;

            while (end <= high && prefix[end] - prefix[i] <= upper)
                end++;

            count += end - start;
        }

        merge(prefix, low, mid, high);

        return count;
    }

    private void merge(long[] arr, int low, int mid, int high) {

        long[] temp = new long[high - low + 1];

        int i = low;
        int j = mid + 1;
        int k = 0;

        while (i <= mid && j <= high) {

            if (arr[i] <= arr[j])
                temp[k++] = arr[i++];
            else
                temp[k++] = arr[j++];
        }

        while (i <= mid)
            temp[k++] = arr[i++];

        while (j <= high)
            temp[k++] = arr[j++];

        for (i = low, k = 0; i <= high; i++, k++)
            arr[i] = temp[k];
    }
}