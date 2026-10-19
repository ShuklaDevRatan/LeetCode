class Solution {
    public List<Integer> targetIndices(int[] nums, int target) {
        int count = 0;
        int frequency = 0;
        for (int num : nums) {
            if (num < target) {
                count++;
            }

            if (num == target) {
                frequency++;
            }
        }

        List<Integer> result = new ArrayList<>();

        for (int i = count; i < count + frequency; i++) {
            result.add(i);
        }

        return result;
    }
}
