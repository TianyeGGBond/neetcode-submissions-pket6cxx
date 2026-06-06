class Solution {
    public int[][] merge(int[][] intervals) {
        List<int[]> res = new ArrayList<>();
        Arrays.sort(intervals, (a,b) -> Integer.compare(a[0], b[0]));

        int curStart = intervals[0][0];
        int curEnd = intervals[0][1];

        for(int i = 1; i < intervals.length; i++){
            int nextStart = intervals[i][0];
            int nextEnd = intervals[i][1];
            if(nextStart <= curEnd){
                nextEnd = Math.max(nextEnd, curEnd);
                nextStart = curStart;
            }else{
                res.add(new int[]{curStart, curEnd});
            }

            curStart = nextStart;
            curEnd = nextEnd;
        }

        res.add(new int[]{curStart, curEnd});
        return res.toArray(new int[res.size()][]);
    }
}
