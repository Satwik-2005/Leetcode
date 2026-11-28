class Solution {
    public ArrayList<Integer> nextLargerElement(int[] arr) {
        int n = arr.length;

        Stack<Integer> stack = new Stack<>();
        ArrayList<Integer> list = new ArrayList<>();

        for(int i = 0; i < n; i++)
            list.add(-1);                    // placeholders so every index exists

        for(int i = n - 1; i >= 0; i--) {
            while(!stack.isEmpty() && stack.peek() <= arr[i])
                stack.pop();

            if(!stack.isEmpty())
                list.set(i, stack.peek());   // set replaces, add inserts

            stack.push(arr[i]);
        }

        return list;
    }
}