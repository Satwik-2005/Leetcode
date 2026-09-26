class Solution {
    public int[][] merge(int[][] intervals) {
        int n = intervals.length;
        Arrays.sort(intervals, (a, b) -> a[0] == b[0] ? Integer.compare(a[1], b[1]) : Integer.compare(a[0], b[0]));
        List<List<Integer>> answer = new ArrayList<>();

        for(int i=0;i<n;i++) {
            if(answer.isEmpty()  ||  intervals[i][0] > answer.get(answer.size() - 1).get(1))
                answer.add(Arrays.asList(intervals[i][0], intervals[i][1]));

            else {
                int lastEnd = answer.get(answer.size() - 1).get(1);

                answer.get(answer.size() - 1).set(1, Math.max(lastEnd, intervals[i][1]));
            }
        }
        
        int[][] res = new int[answer.size()][2];

        for(int i = 0; i < answer.size(); i++) {
            res[i][0] = answer.get(i).get(0);
            res[i][1] = answer.get(i).get(1);
        }

        return res;
    }
}