class Solution {
    public int minAddToMakeValid(String s) {
        int openNeeded = 0;   
        int closeNeeded = 0;  
        
        for(char ch : s.toCharArray()) {
            if(ch == '(') {
                openNeeded += 1;
            } else { 
                if(openNeeded > 0)
                    openNeeded -= 1;
                else
                    closeNeeded += 1;
            }
        }
        
        return openNeeded + closeNeeded;
    }
}