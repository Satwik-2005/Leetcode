// class Solution {
//     public int minMoves(int[] arr) {
//         // code here
//         int n = arr.length;
        
//     }
// }


class Solution {
    public int minMoves(int[] arr) {
        int n = arr.length;

        // Store the position of every value
        int[] pos = new int[n + 1];

        for (int i = 0; i < n; i++) {
            pos[arr[i]] = i;
        }

        int maxLen = 1;
        int currentLen = 1;

        for (int value = 2; value <= n; value++) {

            // value-1 appears before value
            if (pos[value - 1] < pos[value]) {
                currentLen++;
            } else {
                currentLen = 1;
            }

            maxLen = Math.max(maxLen, currentLen);
        }

        return n - maxLen;
    }
}