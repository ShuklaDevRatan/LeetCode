class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> path = new ArrayList<>();

        solve(0, nums, path, ans);

        return ans;
    }

    private void solve(int i, int[] nums, List<Integer> path,
                       List<List<Integer>> ans) {

        // Base Case
        if (i == nums.length) {
            ans.add(new ArrayList<>(path));
            return;
        }

        // TAKE
        path.add(nums[i]);
        solve(i + 1, nums, path, ans);

        // BACKTRACK / UNDO
        path.remove(path.size() - 1);

        // NOT TAKE
        solve(i + 1, nums, path, ans);
    }
}