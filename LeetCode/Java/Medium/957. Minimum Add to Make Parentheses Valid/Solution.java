class Solution {
    public int minAddToMakeValid(String s) {
        int openNeeded = 0;    // unmatched '(' seen so far
        int closeNeeded = 0;   // unmatched ')' that need a '(' inserted before them
        
        for(char ch : s.toCharArray()) {
            if(ch == '(') {
                openNeeded += 1;
            } else { // ch == ')'
                if(openNeeded > 0)
                    openNeeded -= 1;   // this ')' matches a previously unmatched '('
                else
                    closeNeeded += 1;  // no '(' available to match — this ')' is unmatched
            }
        }
        
        return openNeeded + closeNeeded;
    }
}