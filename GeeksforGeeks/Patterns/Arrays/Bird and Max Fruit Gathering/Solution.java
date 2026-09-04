class Solution {
    public int maxFruits(ArrayList<Integer> arr, int m) {
        // code here
        int n =arr.size();
        if(n==0 || m<=0)
            return 0;

        if(m>=n){
            int tot=0;
            for(int x:arr)
                tot+=x;
            return tot;
        }
        int windowsum=0;
        for(int i=0;i<m;i++)
            windowsum+=arr.get(i);

        int maxsum=windowsum;
        for(int i=1;i<n;i++){
            int addindex=(i+m-1)%n;
            int removeindex=i-1;
            windowsum+=arr.get(addindex);
            windowsum-=arr.get(removeindex);
            maxsum=Math.max(maxsum,windowsum);
        }
        return maxsum;
    }
}