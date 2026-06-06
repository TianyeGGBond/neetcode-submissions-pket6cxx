class Solution {
    public int[][] merge(int[][] intervals) {
        if(intervals == null || intervals.length == 0){
            return new int[0][];
        }

        List<int[]> res = new ArrayList<>();
        Arrays.sort(intervals, (a,b) -> Integer.compare(a[0], b[0]));

        int curStart = intervals[0][0];
        int curEnd = intervals[0][1];

        for(int i = 1; i < intervals.length; i++){
            int nextStart = intervals[i][0];
            int nextEnd = intervals[i][1];
            if(nextStart <= curEnd){
                curEnd = Math.max(nextEnd, curEnd);
            }else{
                res.add(new int[]{curStart, curEnd});
                curStart = nextStart;
                curEnd = nextEnd;
            }
        }

        res.add(new int[]{curStart, curEnd});

        return res.toArray(new int[res.size()][]);
    }
}
