class Solution {

    private int distinctSubsequences(int index1, int index2, String s, String t) {
        if(index2 < 0)
            return 1;

        if(index1 < 0)
            return 0;

        if(s.charAt(index1) == t.charAt(index2))
            return distinctSubsequences(index1 - 1, index2 - 1, s, t) + distinctSubsequences(index1 - 1, index2, s, t);

        return distinctSubsequences(index1 - 1, index2, s, t);
    }

    public int numDistinct(String s, String t) {
        int n = s.length();
        int m = t.length();

        return distinctSubsequences(n - 1, m - 1, s, t);
    }
}