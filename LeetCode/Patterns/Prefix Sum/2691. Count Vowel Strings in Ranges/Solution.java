class Solution {

    private void prefixArray(String[] words, int[] prefix, int n) {
        prefix[0] = 0;
        
        for(int i = 0; i < n; i++) {
            char start = words[i].charAt(0);
            char end = words[i].charAt(words[i].length() - 1);
            
            boolean isVowelString = "aeiou".indexOf(start) != -1  &&  "aeiou".indexOf(end) != -1;
            
            prefix[i + 1] = prefix[i] + (isVowelString ? 1 : 0);
        }
    }

    public int[] vowelStrings(String[] words, int[][] queries) {
        int n = words.length;
        int index = 0;

        int[] prefix = new int[n + 1];   // sized n+1 now
        int[] output = new int[queries.length];
        
        prefixArray(words, prefix, n);

        for(int[] query : queries) {
            int initial = query[0];
            int fin = query[1];

            output[index++] = prefix[fin + 1] - prefix[initial];
        }

        return output;
    }
}