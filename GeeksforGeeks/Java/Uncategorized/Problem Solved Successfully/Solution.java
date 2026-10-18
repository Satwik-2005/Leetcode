class Solution {
    public int minimumStep(int n) {
        // code here
        int cnt = 0 ;
       while(n>2){
           cnt+=n%3+1 ;
           n/=3 ;
       }
       return cnt+n-1 ;
    }
}
