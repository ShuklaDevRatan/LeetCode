class Solution {
    public int[] arrayRankTransform(int[] arr) {

        // Step 1: Create a copy of the original array
        int[] sorted = arr.clone();

        // Step 2: Sort the copied array
        Arrays.sort(sorted);

        // Step 3: Store value -> rank
        Map<Integer, Integer> rankMap = new HashMap<>();

        int rank = 1;

        for (int num : sorted) {
            if (!rankMap.containsKey(num)) {
                rankMap.put(num, rank);
                rank++;
            }
        }

        // Step 4: Replace each element with its rank
        for (int i = 0; i < arr.length; i++) {
            arr[i] = rankMap.get(arr[i]);
        }

        return arr;
    }
}