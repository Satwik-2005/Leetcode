class Solution {
    public String removeOuterParentheses(String s) {
        StringBuilder sb = new StringBuilder();
        int level = 0;

        for(char ch : s.toCharArray()) {
            if(ch == '(') {
                if (level > 0)
                    sb.append(ch);
                
                level++;
            }

            if(ch == ')') {
                level--;

                if(level > 0)   
                    sb.append(ch);
            }
        }

        return sb.toString();
    }
}