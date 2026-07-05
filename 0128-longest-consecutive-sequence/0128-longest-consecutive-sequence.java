class Solution {
    public int longestConsecutive(int[] nums) {

        HashSet<Integer> set = new HashSet<>();

        // Step 1: Sare elements HashSet me daal do
        for (int num : nums) {
            set.add(num);
        }

        int longest = 0;

        // Step 2: Har element ko check karo
        for (int num : set) {

            // Sirf tab start karo jab ye sequence ka first element ho
            if (!set.contains(num - 1)) {

                int currentNum = num;
                int currentLength = 1;

                // Aage ke consecutive elements count karo
                while (set.contains(currentNum + 1)) {
                    currentNum++;
                    currentLength++;
                }

                longest = Math.max(longest, currentLength);
            }
        }

        return longest;
    }
}