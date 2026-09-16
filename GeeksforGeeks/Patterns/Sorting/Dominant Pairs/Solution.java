class Solution {
    public int findGreaterValIdx(ArrayList<Integer> firstHalf , int val){
        int left = 0;
        int right = firstHalf.size() - 1;
        int idx = -1;
        while(left <= right){
            int mid = left + (right - left) / 2;
            
            if(firstHalf.get(mid) >= val){
                idx = mid;
                left = mid + 1;
            } else{
                right = mid - 1;
            }
        }
        return idx;
    }
    public int dominantPairs(int[] arr) {
        // Code here
        ArrayList<Integer> firstHalf = new ArrayList<>();

        int n = arr.length;
        for(int i = 0 ; i < n/2 ; i++){
            firstHalf.add(arr[i]);
        }
        Collections.sort(firstHalf , Collections.reverseOrder());

        int dominantPairCnt = 0;

        for(int j = n/2 ; j < n ; j++){

            int idx = findGreaterValIdx(firstHalf , 5*arr[j]);
            if(idx != -1){
                dominantPairCnt += (idx - 0 + 1);
            }
        }
        return dominantPairCnt;
    }
}