class Solution {
    public int maxProduct(int[] arr, int k) {
        int n = arr.length;
        
        Arrays.sort(arr);

        if (k == n) {
            long prod = 1;
            for (int x : arr) prod *= x;
            return (int) prod;
        }

        if (arr[n - 1] <= 0 && k % 2 != 0) {
            long prod = 1;

            for (int i = n - 1; i >= n - k; i--) {
                prod *= arr[i];
            }

            return (int) prod;
        }

        int left = 0;
        int right = n - 1;
        long maxProd = 1;

        if (k % 2 != 0) {
            maxProd *= arr[right];
            right--;
            k--;
        }

        while (k > 0) {
            long leftPair = (long) arr[left] * arr[left + 1];
            long rightPair = (long) arr[right] * arr[right - 1];

            if (leftPair > rightPair) {
                maxProd *= leftPair;
                left += 2;
            } else {
                maxProd *= rightPair;
                right -= 2;

            }

            k -= 2;

        }

        return (int) maxProd;

    }

}