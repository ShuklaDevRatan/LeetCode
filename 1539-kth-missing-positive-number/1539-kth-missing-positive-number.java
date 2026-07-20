class Solution {
    public int findKthPositive(int[] arr, int k) {

        int pointer = 0;
        int current = 1;
        int count = 0;

        while (count < k) {

            if (pointer < arr.length && current == arr[pointer]) {
                pointer++;
            } else {
                count++;
                if (count == k) {
                    return current;
                }
            }

            current++;
        }

        return -1;
    }
}