class Solution {
    ArrayList<Integer> nthRowOfPascalTriangle(int n) {
        // code here
        ArrayList<Integer> list = new ArrayList<>();
        int ans = 1;
        
        list.add(ans);
        
        for(int i=1;i<n;i++) {
            ans = ans * (n - i);
            ans = ans / i;
            list.add(ans);
        }
        
        return list;
    }
}