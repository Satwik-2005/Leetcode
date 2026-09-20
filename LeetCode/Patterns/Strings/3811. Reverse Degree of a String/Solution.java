class Solution {
    public int reverseDegree(String s) {
        int degree = 0;
        int i = 1;
        for(char ch : s.toCharArray()){
            int revPos = 'z' - ch + 1;
            degree += revPos * i;
            i++;
        }
        return degree;
    }
}