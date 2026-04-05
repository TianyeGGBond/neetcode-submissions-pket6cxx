class Solution {
    public int minCostConnectPoints(int[][] points) {
        //prim
        //find 1 node
        //renew the dis to unvisited others
        //heap pick min, ++ turn visited
        //recurse
        int res = 0;
        int count = 0;
        int len = points.length;
        boolean[] visited = new boolean[len];

        //ind, dis
        PriorityQueue<int[]> heap = new PriorityQueue<>((a,b) -> (a[1] - b[1]));
        heap.offer(new int[]{0,0});
        

        while(count < len && !heap.isEmpty()){
            int[] cur = heap.poll();
            int curIdx = cur[0];
            if(visited[curIdx]) continue;
            res += cur[1];
            count++;
            visited[curIdx] = true;

            for(int i = 0; i < len ; i++){
                if(!visited[i]){
                    int dis = Math.abs(points[i][0] - points[curIdx][0]) +
                              Math.abs(points[i][1] - points[curIdx][1]);
                    heap.offer(new int[]{i, dis});
                }
            }
        }
        return res;
    }
}
