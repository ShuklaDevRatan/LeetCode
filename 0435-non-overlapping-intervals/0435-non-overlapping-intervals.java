class Solution {
    public int eraseOverlapIntervals(int[][] intervals) {

        // Sort intervals according to ending point
        Arrays.sort(intervals, (a, b) -> a[1] - b[1]);

        int count = 0;
        int lastEnd = intervals[0][1];

        for (int i = 1; i < intervals.length; i++) {

            int start = intervals[i][0];
            int end = intervals[i][1];

            // Overlap
            if (start < lastEnd) {
                count++;
            }
            // No overlap
            else {
                lastEnd = end;
            }
        }

        return count;
    }
}