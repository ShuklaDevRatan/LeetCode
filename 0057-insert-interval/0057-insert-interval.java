class Solution {
    public int[][] insert(int[][] intervals, int[] newInterval) {

        List<int[]> result = new ArrayList<>();

        int i = 0;

        // 1. Jo intervals newInterval se completely pehle hain
        while (i < intervals.length &&
               intervals[i][1] < newInterval[0]) {

            result.add(intervals[i]);
            i++;
        }

        // 2. Overlapping intervals ko merge karo
        while (i < intervals.length &&
               intervals[i][0] <= newInterval[1]) {

            newInterval[0] = Math.min(newInterval[0], intervals[i][0]);
            newInterval[1] = Math.max(newInterval[1], intervals[i][1]);

            i++;
        }

        // 3. Merged newInterval add karo
        result.add(newInterval);

        // 4. Jo intervals newInterval ke completely baad hain
        while (i < intervals.length) {

            result.add(intervals[i]);
            i++;
        }

        return result.toArray(new int[result.size()][]);
    }
}