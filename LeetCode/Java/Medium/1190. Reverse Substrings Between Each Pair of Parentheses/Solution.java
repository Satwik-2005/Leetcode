class Solution {
    public String reverseParentheses(String s) {
        Stack<StringBuilder> stack = new Stack<>();
        stack.push(new StringBuilder());
        
        for(char ch : s.toCharArray()) {
            if(ch == '(') {
                stack.push(new StringBuilder());
            } 
            else if(ch == ')') {
                StringBuilder finished = stack.pop();
                finished.reverse();
                stack.peek().append(finished);
            } 
            else {
                stack.peek().append(ch);
            }
        }
        
        return stack.pop().toString();
    }
}