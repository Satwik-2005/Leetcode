class Solution {

    static int res = Integer.MAX_VALUE;

    static void findMinPath(List<List<Integer>> triangle , int index , int sum , int level) {
        if(level == triangle.size()) {
            res = Math.min(res , sum);
            return;
        }

        sum += triangle.get(level).get(index);

        findMinPath(triangle , index , sum , level + 1);
        findMinPath(triangle , index + 1 , sum , level + 1);
    }

    public int minimumTotal(List<List<Integer>> triangle) {
        res = Integer.MAX_VALUE;
        findMinPath(triangle , 0 , 0, 0);
        return res;
    }
}