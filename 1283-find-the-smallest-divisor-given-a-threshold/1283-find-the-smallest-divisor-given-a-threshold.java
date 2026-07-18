class Solution {

    public int smallestDivisor(int[] nums, int threshold) {

        int start = 1;
        int end = 0;

        // Find maximum element
        for (int num : nums) {
            end = Math.max(end, num);
        }

        int answer = end;

        while (start <= end) {

            int mid = start + (end - start) / 2;

            int sum = 0;

            for (int num : nums) {
                sum += (int)Math.ceil((double)num / mid);
            }

            if (sum <= threshold) {
                answer = mid;
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        }

        return answer;
    }
}