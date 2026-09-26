class Solution {

    private void findAllCombinations (
        int index, int target, int[] candidates,
        List<List<Integer>> combinations,
        List<Integer> combination
    ) {

        if(index == candidates.length) {
            if(target == 0) 
                combinations.add(new ArrayList<>(combination));

            return;
        }

        if(candidates[index] <= target) {
            combination.add(candidates[index]);

            findAllCombinations(index, target - candidates[index], candidates, combinations, combination);

            combination.remove(combination.size() - 1);
        }
        
        findAllCombinations(index + 1, target, candidates, combinations, combination);

    }

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        int n = candidates.length;
        
        List<List<Integer>> combinations = new ArrayList<>();
        List<Integer> list = new ArrayList<>();

        findAllCombinations(0, target, candidates, combinations, list);

        return combinations;
    }
}