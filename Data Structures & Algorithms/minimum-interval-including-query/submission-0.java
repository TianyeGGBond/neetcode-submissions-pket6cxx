class Solution {
    public int[] minInterval(int[][] intervals, int[] queries) {
        Arrays.sort(intervals, (a,b) -> a[0] - b[0]);
        int m = intervals.length;
        
        int n = queries.length;
        int[][] qArr = new int[n][2];
        for(int i = 0; i < n; i++){
            qArr[i][0] = queries[i];
            qArr[i][1] = i;
        }
        Arrays.sort(qArr, (a,b) -> (a[0] - b[0]));

        int[] res = new int[n];

        PriorityQueue<int[]> heap = new PriorityQueue<>
            ((a,b) -> (a[0] - b[0]));
        
        int j = 0;
        for(int i = 0; i < n; i++){
            int q = qArr[i][0];
            while(j < m && intervals[j][0] <= q){
                int len = intervals[j][1] - intervals[j][0] + 1;
                heap.offer(new int[]{len, intervals[j][1]});
                j++;
            }
            while(!heap.isEmpty() && heap.peek()[1] < q){
                heap.poll();
            }
            res[qArr[i][1]] = heap.isEmpty()? -1 : heap.peek()[0];
        }
        return res;
    }
}
