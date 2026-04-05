class Solution {
    private static final int[][] dirs = {{1,0}, {-1,0},{0,1},{0,-1}};
    public int maxAreaOfIsland(int[][] grid) {
        int max = 0;
        if(grid == null || grid.length == 0 || grid[0].length == 0) return max;

        for(int i = 0; i < grid.length; i++){
            for(int j = 0; j< grid[0].length; j++){
                if(grid[i][j] == 1) {
                    max = Math.max(max, dfs(grid, i, j));
                }
            }
        }
        return max;
    }
    private int dfs(int[][] grid, int r, int c){
        if(r >= 0 && r < grid.length &&
           c >= 0 && c < grid[0].length &&
           grid[r][c] == 1
         ){
            grid[r][c] = 0;
        }else{
            return 0;
        }
        int area = 1;

        for(int[] dir : dirs){
            area += dfs(grid, r + dir[0], c + dir[1]);
        }
        return area;
    }
}
