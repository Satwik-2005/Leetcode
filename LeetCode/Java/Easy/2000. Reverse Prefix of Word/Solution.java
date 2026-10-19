class Solution {

    private String reverse(String word) {
        StringBuilder sb = new StringBuilder();

        for(int i = word.length() - 1; i >= 0; i--)
            sb.append(word.charAt(i));

        return sb.toString();
    }

    private int findFirstOccurance(String word, int n, char ch) {
        for(int i = 0; i < n; i++)
            if(word.charAt(i) == ch)
                return i;

        return -1;
    }

    public String reversePrefix(String word, char ch) {
        int n = word.length();

        int index = findFirstOccurance(word, n, ch);

        if(index == -1)
            return word;  
            
        return reverse(word.substring(0, index + 1)) + word.substring(index + 1);
    }
}