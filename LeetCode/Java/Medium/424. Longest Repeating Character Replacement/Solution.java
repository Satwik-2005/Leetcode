class Solution {
    public int characterReplacement(String str, int k) {
        int n = str.length();

        int[] hash = new int[26];
        int left = 0;
        int right = 0;
        
        int maxLength = 0;
        int maxFrequency = 0;

        while(right < n) {
            char ch = str.charAt(right);

            hash[ch - 'A'] += 1;
            maxFrequency = Math.max(maxFrequency, hash[ch - 'A']);

            if((right - left + 1) - maxFrequency  >  k) {
                hash[str.charAt(left) - 'A'] -= 1;

                left += 1;
            }

            if((right - left + 1) - maxFrequency <= k)
                maxLength = Math.max(maxLength, right - left + 1);

            right += 1;
        }

        return maxLength;
    }
}