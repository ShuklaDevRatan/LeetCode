class Solution {
    public int minimumOperations(int[] nums) {
        int operations = 0;

        for (int num : nums) {

            int remainder = num % 3;

            if (remainder != 0) {
                operations++;
            }
        }

        return operations;
    }
}
