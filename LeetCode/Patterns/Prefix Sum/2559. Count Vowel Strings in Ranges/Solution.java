class Solution {

    private void prefixArray(String[] words, int[] prefix, int n) {
        if("aeiou".indexOf(words[0].charAt(0)) != -1  &&  "aeiou".indexOf(words[0].charAt(words[0].length() - 1)) != -1)
            prefix[0] = 1;
        
        for(int i=1;i<n;i++) {
            char start = words[i].charAt(0);
            char end = words[i].charAt(words[i].length() - 1);

            if("aeiou".indexOf(start) != -1  &&  "aeiou".indexOf(end) != -1)
                prefix[i] = prefix[i - 1] + 1;
            else
                prefix[i] = prefix[i - 1];
        }
    }

    public int[] vowelStrings(String[] words, int[][] queries) {
        int n = words.length;
        int index = 0;

        int[] prefix = new int[n];
        int[] output = new int[queries.length];
        
        prefixArray(words, prefix, n);

        for(int element : prefix)
            System.out.println(element);

        for(int[] query : queries) {
            int initial = query[0];
            int fin = query[1];

            int before = (initial == 0) ? 0 : prefix[initial - 1];
            output[index++] = prefix[fin] - before;
        }

        return output;
    }
}