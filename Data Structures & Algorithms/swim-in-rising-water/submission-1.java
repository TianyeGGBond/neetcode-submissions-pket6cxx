class Solution {
    private final int[][] dirs = {{1,0},{-1,0},{0,-1},{0,1}};
    public int swimInWater(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        PriorityQueue<int[]> heap = new PriorityQueue<>((a, b) -> (a[0] - b[0]));
        boolean[][] visited = new boolean[n][m];

        int water = 0;
        heap.offer(new int[]{grid[0][0],0,0});

        while(!heap.isEmpty()){
            int[] cur = heap.poll();
            int x = cur[1];
            int y = cur[2];
            visited[x][y] = true;

                water = Math.max(water, cur[0]);

                if (x == n-1 && y == n-1) break;

                for(int[] dir : dirs){
                    int row = x + dir[0];
                    int col = y + dir[1];
                    if(row >= 0 && row < n &&
                       col >= 0 && col < n &&
                       !visited[row][col]){
                            heap.offer(new int[]{grid[row][col], row, col});
                       }
            }
        }
        return water;
    }
}
