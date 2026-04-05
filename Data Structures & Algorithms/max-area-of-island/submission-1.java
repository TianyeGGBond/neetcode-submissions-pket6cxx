class Solution {
    int max = 0;
    int area = 0;
    private static final int[][] dirs = {{1,0}, {-1,0},{0,1},{0,-1}};
    public int maxAreaOfIsland(int[][] grid) {
        if(grid == null || grid.length == 0 || grid[0].length == 0) return max;
        for(int i = 0; i < grid.length; i++){
            for(int j = 0; j< grid[0].length; j++){
                dfs(grid, i, j);
                max = Math.max(max, area);
                area = 0;
            }
        }
        return max;
    }
    private void dfs(int[][] grid, int r, int c){
        if(r >= 0 && r < grid.length &&
           c >= 0 && c < grid[0].length &&
           grid[r][c] == 1
         ){
            grid[r][c] = 0;
            area++;
        }else{
            return;
        }
    
        for(int[] dir : dirs){
            int nr = r + dir[0];
            int nc = c + dir[1];
            dfs(grid, nr, nc);
        }
    }
}
