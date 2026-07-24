class Solution {
    public int eraseOverlapIntervals(int[][] intervals) {
           // If there is only one interval, return it directly
       if (intervals.length == 0) {
            return 0;
        }

        // Sort by END time (this is the key difference from merge intervals)
        Arrays.sort(intervals, Comparator.comparingInt(i -> i[1]));

        int count = 0; // number of intervals removed
        int prevEnd = intervals[0][1]; // end time of the last interval we decided to KEEP

        for (int i = 1; i < intervals.length; i++) {
            int start = intervals[i][0];
            int end = intervals[i][1];

            if (start < prevEnd) {
                // Overlap -> remove this interval
                // (we keep the previously chosen one since it ends earlier or equal,
                // which leaves more room for future intervals)
                count++;
            } else {
                // No overlap -> keep this interval, update prevEnd
                prevEnd = end;
            }
        }

        return count;
    }
}
