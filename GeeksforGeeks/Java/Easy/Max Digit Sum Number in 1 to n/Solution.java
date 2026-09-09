class Solution {
    public int findMax(int n) {
        if (n < 10) return n;

        // store digits in normal order
        ArrayList<Integer> arr = new ArrayList<>();
        int sum = 0, tempN = n;
        while (tempN > 0) {
            arr.add(0, tempN % 10);
            sum += tempN % 10;
            tempN /= 10;
        }

        int m = arr.size(), ansSum = sum, idx = -1, suffSum = arr.get(m - 1);

        // check candidates
        for (int i = m - 2; i >= 0; i--) {
            if (arr.get(i) == 0) continue;
            suffSum += arr.get(i);
            int newSum = sum - suffSum + (arr.get(i) - 1) + 9 * (m - i - 1);
            if (newSum > ansSum) {
                ansSum = newSum;
                idx = i;
            }
        }
        if (idx == -1) return n;

        // build result
        int result = 0;
        for (int i = 0; i < m; i++) {
            if (i < idx) result = result * 10 + arr.get(i);
            else if (i == idx) result = result * 10 + arr.get(i) - 1;
            else result = result * 10 + 9;
        }
        return result;
    }
}