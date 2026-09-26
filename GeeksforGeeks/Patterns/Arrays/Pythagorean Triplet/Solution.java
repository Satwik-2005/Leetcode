class Solution {
    boolean pythagoreanTriplet(int[] arr) {
        int n = arr.length;

        if(n < 3)
            return false;

        // Map square value -> count of elements producing it, to handle duplicates safely
        Map<Long, Integer> squareCount = new HashMap<>();
        for(int ele : arr) {
            long sq = (long) ele * ele;
            squareCount.merge(sq, 1, Integer::sum);
        }

        for(int i = 0; i < n; i++) {
            for(int j = i + 1; j < n; j++) {
                long sumSq = (long) arr[i] * arr[i] + (long) arr[j] * arr[j];

                Integer count = squareCount.get(sumSq);
                if(count == null) continue;

                // Check if sumSq corresponds to a genuinely different element (not a or b itself)
                long aSq = (long) arr[i] * arr[i];
                long bSq = (long) arr[j] * arr[j];

                if(sumSq != aSq && sumSq != bSq) {
                    return true; // there's a third distinct value equal to sumSq
                } else {
                    // sumSq equals one of a's/b's own square — need at least 2 occurrences of that square value
                    if(count >= 2) 
                        return true;
                }
            }
        }

        return false;
    }
}