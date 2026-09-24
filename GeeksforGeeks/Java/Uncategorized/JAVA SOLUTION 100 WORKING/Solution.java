class Solution {
    public ArrayList<Integer> largestSubset(int[] arr) {

        //Sorting in Descending order
        Arrays.sort(arr);
        int it = 0;
        int jt = arr.length-1;
        while(it < jt){
            int t = arr[it];
            arr[it] = arr[jt];
            arr[jt] = t;
            it++;
            jt--;
        }

        //Initializing dp and hash array and fill them with values 1 and -1 respectively
        int[] dp = new int[arr.length];
        int[] hash = new int[arr.length];

        Arrays.fill(dp,1);
        Arrays.fill(hash,-1);

        int max = 1;
        int idx = 0;

        //since the array is sorted we dont have to check if arr[j] > arr[i]
        for(int i = 0 ; i < arr.length ; i++){
            for(int j = 0 ; j < i ; j++){
                if(arr[j]%arr[i] == 0 && dp[j]+1 > dp[i]){
                    dp[i] = dp[j]+1;
                    hash[i] = j;
                }
            }

            // storing the last index
            if(dp[i] > max){
                max = dp[i];
                idx = i;
            }
        }

        //adding values to the arraylist till the prev element is -1(not visited)
        ArrayList<Integer> ans = new ArrayList<>();
        while(idx != -1){
            ans.add(arr[idx]);
            idx = hash[idx];
        }

        return ans;

    }
}