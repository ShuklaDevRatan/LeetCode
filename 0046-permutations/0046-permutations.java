class Solution {

    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();

        permute(nums, 0, ans);

        return ans;
    }

    private void permute(int[] nums, int index, List<List<Integer>> ans) {

        if (index == nums.length) {
            List<Integer> permutation = new ArrayList<>();

            for (int num : nums) {
                permutation.add(num);
            }

            ans.add(permutation);
            return;
        }

        for (int i = index; i < nums.length; i++) {

            swap(nums, index, i);

            permute(nums, index + 1, ans);

            swap(nums, index, i);
        }
    }

    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}