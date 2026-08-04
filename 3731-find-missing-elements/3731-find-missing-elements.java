class Solution {
    public List<Integer> findMissingElements(int[] nums) {
       
        Arrays.sort(nums);

        List<Integer> ans = new ArrayList<>();

        for (int i = 0; i < nums.length - 1; i++) {

            for (int num = nums[i] + 1; num < nums[i + 1]; num++) {
                ans.add(num);
            }
        }

        return ans;
    }
}