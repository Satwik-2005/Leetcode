import java.util.*;

class Solution {

    static ArrayList<ArrayList<Integer>> formCoils(int n) {

        int size = 4 * n;
        int total = size * size;
        int required = 8 * n * n;

        // Create matrix
        int[][] mat = new int[size][size];

        int value = 1;

        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                mat[i][j] = value++;
            }
        }

        ArrayList<Integer> coil1 = new ArrayList<>();

        int top = 0;
        int bottom = size - 1;
        int left = 0;
        int right = size - 2;

        while (coil1.size() < required) {

            // 1. Down
            for (int i = top; i <= bottom && coil1.size() < required; i++) {
                coil1.add(mat[i][left]);
            }
            left++;

            // 2. Right
            for (int j = left; j <= right && coil1.size() < required; j++) {
                coil1.add(mat[bottom][j]);
            }
            bottom--;

            // 3. Up
            for (int i = bottom; i > top && coil1.size() < required; i--) {
                coil1.add(mat[i][right]);
            }
            right--;

            // 4. Left
            top++;

            for (int j = right; j > left && coil1.size() < required; j--) {
                coil1.add(mat[top][j]);
            }

            // Move to the next inner coil layer
            left++;
            bottom--;
            right--;
            top++;
        }

        ArrayList<Integer> coil2 = new ArrayList<>();

        for (int x : coil1) {
            coil2.add(total + 1 - x);
        }

        ArrayList<ArrayList<Integer>> result = new ArrayList<>();

        result.add(coil1);
        result.add(coil2);

        return result;
    }
}