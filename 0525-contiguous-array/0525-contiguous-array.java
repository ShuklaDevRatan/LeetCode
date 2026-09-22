class Solution {
    public int findMaxLength(int[] nums) {

        HashMap<Integer, Integer> map = new HashMap<>();

        map.put(0, -1);

        int prefixSum = 0;
        int maxLength = 0;

        for (int i = 0; i < nums.length; i++) {

            if (nums[i] == 0) {
                prefixSum--;
            } else {
                prefixSum++;
            }

            if (map.containsKey(prefixSum)) {
                int length = i - map.get(prefixSum);
                maxLength = Math.max(maxLength, length);
            } else {
                map.put(prefixSum, i);
            }
        }

        return maxLength;
    }
}