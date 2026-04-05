class Solution {
    public int eraseOverlapIntervals(int[][] intervals) {
        Arrays.sort(intervals, (a,b) -> (a[0] - b[0]));
        int n = intervals.length, count = 0;
        if(n == 0) return 0;
        for(int i = 1; i < n; i++){
            if(intervals[i-1][1] > intervals[i][0]){
                count++;
                intervals[i][1] = Math.min(intervals[i][1], intervals[i-1][1]);
            }
        }
        return count;
    }
}
