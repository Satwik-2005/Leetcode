class Solution {

    public int longestSubseq(int[] arr) {

        if (arr == null || arr.length == 0) {

            return 0;

        }



        // Map to store the maximum length of a valid subsequence ending with a specific number

        Map<Integer, Integer> dp = new HashMap<>();

        int maxLength = 0;



        for (int num : arr) {

            // Check lengths of subsequences ending in (num - 1) and (num + 1)

            int lenFromLess = dp.getOrDefault(num - 1, 0);

            int lenFromMore = dp.getOrDefault(num + 1, 0);



            // The current number can extend either of those subsequences

            int currentLength = Math.max(lenFromLess, lenFromMore) + 1;



            // Update the map for the current number with the maximum possible length

            dp.put(num, Math.max(dp.getOrDefault(num, 0), currentLength));



            // Track the overall maximum length found so far

            maxLength = Math.max(maxLength, currentLength);

        }



        return maxLength;

    }



}