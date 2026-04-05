class Solution {
    private static final int[][] dirs = {{1,0},{-1,0},{0,1},{0,-1}};

    public int orangesRotting(int[][] grid) {
        int rows = grid.length;
        int cols = grid[0].length;

        Queue<int[]> q = new LinkedList<>();
        
        for(int i = 0; i < rows; i++){
            for(int j = 0; j < cols; j++){
                if (grid[i][j] == 2){
                    q.offer(new int[]{i,j});
                }
            }
        }
        int min = -1;

        while(!q.isEmpty()){
            int size = q.size();
            min++;
            for(int i = 0; i < size; i++){
                // current layer rotten fruits
                int[] cur = q.poll();
                int r = cur[0];
                int c = cur[1];

                //going to infect more
                //uninfectable - pass
                for(int[] dir : dirs){
                    int nr = r + dir[0];
                    int nc = c + dir[1];
                    if(nr < 0 || nr >= rows ||
                       nc < 0 || nc >= cols ||
                       grid[nr][nc] != 1) continue;
                    grid[nr][nc] = 2;
                    q.offer(new int[]{nr, nc});
                    
                }
            }
        }

        for(int i = 0; i < rows; i++){
            for(int j = 0; j < cols; j++){
                if (grid[i][j] == 1) return -1;
            }
        }
        return min == -1? 0: min;

    }
}
