class Solution {

    public List<List<Integer>> combinationSum2(int[] candidates, int target) {

        List<List<Integer>> result = new ArrayList<>();

        Arrays.sort(candidates);

        backtrack(0, candidates, target, new ArrayList<>(), result);

        return result;
    }

    private void backtrack(
            int index,
            int[] candidates,
            int target,
            List<Integer> ans,
            List<List<Integer>> result) {

        if (index == candidates.length || candidates[index] > target) {
            if (target == 0) {
                result.add(new ArrayList<>(ans));
                return;
            }
            return;
        }

        for (int i = index; i < candidates.length; i++) {

            // Same level par duplicate value skip
            if (i > index && candidates[i] == candidates[i - 1]) {
                continue;
            }

            // Remaining target se bada hai
            if (candidates[i] > target) {
                break;
            }

            ans.add(candidates[i]);

            // i + 1 because same element dobara use nahi karna
            backtrack(i + 1, candidates, target - candidates[i], ans, result);

            // Backtrack
            ans.remove(ans.size() - 1);
        }
    }
}