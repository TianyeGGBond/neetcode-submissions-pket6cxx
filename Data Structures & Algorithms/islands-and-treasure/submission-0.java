class Solution {
    private static final int[][] dirs = {{1,0},{-1,0},{0,1},{0,-1}};
    int INF = 2147483647;
    int rows, cols;

    public void islandsAndTreasure(int[][] grid) {
        this.rows = grid.length;
        this.cols = grid[0].length;
        for(int i = 0; i < rows; i++){
            for(int j = 0; j < cols; j++){
                if(grid[i][j] != 0 && grid[i][j] != -1){
                    grid[i][j] = bfs(grid, i, j);
                }
            }
        }
    }
    private int bfs(int[][] grid, int r, int c){
        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[]{r,c});

        boolean[][] visited = new boolean[rows][cols];
        visited[r][c] = true;

        int step = 0;

        while(!q.isEmpty()){
            int size = q.size();

            for (int i = 0; i < size; i++){
                int[] cur = q.poll();

                for(int[] dir : dirs){
                    int nr = cur[0] + dir[0];
                    int nc = cur[1] + dir[1];
                        if( nr >= 0 && nr < rows &&
                            nc >= 0 && nc < cols &&
                            grid[nr][nc] == 0){
                            return ++step;
                        }else if( 
                            nr >= 0 && nr < rows &&
                            nc >= 0 && nc < cols &&
                            grid[nr][nc] != -1 &&
                            !visited[nr][nc]){
                            q.offer(new int[]{nr,nc});
                            visited[nr][nc] = true;
                        }
                }
            }
            step++;
        }

        return INF;
    }
}
