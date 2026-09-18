class Solution {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {

        int[] nextGreater = new int[10001];
        int[] stack = new int[nums2.length];
        int top = -1;

        for (int num : nums2) {

            while (top >= 0 && stack[top] < num) {
                nextGreater[stack[top--]] = num;
            }

            stack[++top] = num;
        }

        while (top >= 0) {
            nextGreater[stack[top--]] = -1;
        }

        int[] ans = new int[nums1.length];

        for (int i = 0; i < nums1.length; i++) {
            ans[i] = nextGreater[nums1[i]];
        }

        return ans;
    }
}