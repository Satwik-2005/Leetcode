
class Solution {
    public int minStepToReachTarget(int kPos[], int tPos[], int n) {
        // code here
        int[][] validCordinates = {{2,1},{2,-1},{-2,1},{-2,-1},{1,2},{1,-2},{-1,2},{-1,-2}};

        Queue<int[]> q = new LinkedList<>();
        boolean[][] visited = new boolean[n][n];

        q.offer(new int[]{kPos[0]-1,kPos[1]-1,0});//0th index--> x , 1st index --> y , 2nd index --> steps

        visited[kPos[0]-1][kPos[1]-1] = true;

        while(!q.isEmpty()){
            int[] currCell = q.poll();
            int x = currCell[0];
            int y = currCell[1];
            int steps = currCell[2];
            if(x == tPos[0]-1 && y == tPos[1]-1){
                return steps;
            }

            for(int[] vc : validCordinates){
                int newX = x + vc[0];
                int newY = y + vc[1];
                int newSteps = steps + 1;
                if(newX >= 0 && newX < n && newY >= 0 && newY < n && !visited[newX][newY]){
                    q.offer(new int[]{newX,newY,newSteps});
                    visited[newX][newY] = true;
                }
            }
        }

        return -1;
    }
}