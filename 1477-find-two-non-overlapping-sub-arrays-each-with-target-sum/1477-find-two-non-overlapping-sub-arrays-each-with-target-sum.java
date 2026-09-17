class Solution {
    public int minSumOfLengths(int[] arr, int target) {

        int n = arr.length;
        int[] best = new int[n];

        Arrays.fill(best, Integer.MAX_VALUE);

        int left = 0;
        int sum = 0;
        int answer = Integer.MAX_VALUE;

        for (int right = 0; right < n; right++) {

            sum += arr[right];

            while (sum > target) {
                sum -= arr[left];
                left++;
            }

            // Current index tak previous best carry forward
            if (right > 0) {
                best[right] = best[right - 1];
            }

            // Current window is a valid sub-array
            if (sum == target) {

                int currentLength = right - left + 1;

                // Previous non-overlapping sub-array
                if (left > 0 && best[left - 1] != Integer.MAX_VALUE) {
                    answer = Math.min(
                        answer,
                        currentLength + best[left - 1]
                    );
                }

                // Current sub-array can become previous for future
                best[right] = Math.min(
                    best[right],
                    currentLength
                );
            }
        }

        return answer == Integer.MAX_VALUE ? -1 : answer;
    }
}