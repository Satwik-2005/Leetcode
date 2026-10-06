class Solution {
    public int minAddToMakeValid(String s) {
        int n = s.length();

        if(n == 0)
            return 0;

        int count = 0;

        Stack<Character> stack = new Stack<>();

        for(char ch : s.toCharArray()) {
            if(ch == '(') {
                stack.push(ch);
                count += 1;
            }

            else if(!stack.isEmpty()  &&  stack.peek() == '('  &&  ch == ')') {
                stack.pop();
                count -= 1;
            }

            else {
                stack.push(ch);
                count += 1;
            }
        }

        return count;
    }
}