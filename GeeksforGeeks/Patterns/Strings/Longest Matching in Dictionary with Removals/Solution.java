class Solution {
    public String findLongestWord(String s, List<String> d) {

        int n = s.length();

        // vec[i][c] = next position of character c after/at position i
        int[][] vec = new int[n][26];

        // Initialize all positions with -1
        for (int i = 0; i < n; i++) {
            Arrays.fill(vec[i], -1);
        }

        int[] next = new int[26];
        Arrays.fill(next, -1);

        next[s.charAt(n - 1) - 'a'] = n - 1;
        vec[n - 1] = next.clone();

        Map<Character, Integer> mp = new HashMap<>();
        mp.put(s.charAt(n - 1), n - 1);

        for (int i = n - 2; i >= 0; i--) {
            next[s.charAt(i + 1) - 'a'] = i + 1;
            vec[i] = next.clone();

            mp.put(s.charAt(i), i);
        }

        List<String> ans = new ArrayList<>();
        int maxi = 0;

        for (String word : d) {

            if (!mp.containsKey(word.charAt(0))) {
                continue;
            }

            int pos = mp.get(word.charAt(0));
            int j = 1;

            for (; j < word.length(); j++) {

                pos = vec[pos][word.charAt(j) - 'a'];

                if (pos == -1) {
                    break;
                }
            }

            if (j == word.length()) {
                ans.add(word);
                maxi = Math.max(maxi, word.length());
            }
        }

        Collections.sort(ans);

        for (String word : ans) {
            if (word.length() == maxi) {
                return word;
            }
        }

        return "";
    }
}