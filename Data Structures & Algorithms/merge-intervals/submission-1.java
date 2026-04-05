class Solution {
    public int[][] merge(int[][] intervals) {
        Arrays.sort(intervals, (a,b) -> (a[0] - b[0]));
        int n = intervals.length;
        List<int[]> res = new ArrayList<>();
        res.add(intervals[0]);
        for(int i = 1; i < n; i++){
            int[] cur = res.get(res.size() - 1);
            if(cur[1] < intervals[i][0]){
                res.add(intervals[i]);
            }else{
                res.remove(res.size() - 1);
                cur[1] = Math.max(cur[1],intervals[i][1]);
                res.add(cur);
            }
        }
        return res.toArray(new int[res.size()][2]);
    }
}
