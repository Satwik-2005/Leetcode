class Solution {
    public int pairCount(int x, int y) {
        // code here
        int ans=0,b=x*y,a=1;
        while(a<=b){
            int g=gcd(a,b);
            if(g==x && (a*b)/g==y) ans+=a==b?1:2;
            a++;
            b=(x*y)/a;
        }
        return ans;
    }
    public int gcd(int a,int b){
        if(b==0) return a;
        return gcd(b,a%b);
    }
}