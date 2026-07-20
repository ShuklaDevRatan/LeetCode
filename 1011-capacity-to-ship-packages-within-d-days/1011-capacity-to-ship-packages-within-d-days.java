class Solution {

    public int shipWithinDays(int[] weights, int days) {

        int start = 0;
        int end = 0;

        // Find search space
        for (int weight : weights) {
            start = Math.max(start, weight);
            end += weight;
        }

        int answer = end;

        while (start <= end) {

            int mid = start + (end - start) / 2;

            if (canShip(weights, mid, days)) {
                answer = mid;
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        }

        return answer;
    }

    private boolean canShip(int[] weights, int capacity, int days) {

        int requiredDays = 1;
        int currentLoad = 0;

        for (int weight : weights) {

            if (currentLoad + weight <= capacity) {
                currentLoad += weight;
            } else {
                requiredDays++;
                currentLoad = weight;
            }

            if (requiredDays > days) {
                return false;
            }
        }

        return true;
    }
}