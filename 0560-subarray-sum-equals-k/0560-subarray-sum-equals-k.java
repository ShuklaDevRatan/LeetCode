class Solution {
    public int subarraySum(int[] nums, int k) {
        HashMap<Integer, Integer> map = new HashMap<>();

        // Prefix sum 0 ek baar initially present hai
        map.put(0, 1);

        int prefixSum = 0;
        int count = 0;

        for (int num : nums) {

            prefixSum += num;

            // Check karo ki (prefixSum - k) pehle aaya tha ya nahi
            if (map.containsKey(prefixSum - k)) {
                count += map.get(prefixSum - k);
            }

            // Current prefix sum ki frequency update karo
            map.put(prefixSum, map.getOrDefault(prefixSum, 0) + 1);
        }

        return count;
    }
}