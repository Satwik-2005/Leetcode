class Solution {

    private void findCombinations (
        int index, int target, int[] candidates, int n,
        List<List<Integer>> combinations,
        List<Integer> uniqueCombinations
    ) {
        if(target == 0) {
            combinations.add(new ArrayList<>(uniqueCombinations));
            return;
        }

        for(int i=index;i<n;i++) {
            if(i > index  &&  candidates[i] == candidates[i - 1])
                continue;

            if(candidates[i] > target)
                break;

            uniqueCombinations.add(candidates[i]);

            findCombinations(i + 1, target - candidates[i], candidates, n, combinations, uniqueCombinations);

            uniqueCombinations.remove(uniqueCombinations.size() - 1);
        }
    }

    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        int n = candidates.length;

        Arrays.sort(candidates);
        
        List<List<Integer>> combinations = new ArrayList<>();
        List<Integer> uniqueCombination = new ArrayList<>();

        findCombinations(0, target, candidates, n, combinations, uniqueCombination);

        return combinations;
    }
}