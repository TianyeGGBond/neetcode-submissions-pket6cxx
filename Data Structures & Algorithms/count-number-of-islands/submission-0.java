class Solution {
    int[][] dirs = {{1,0}, {-1,0}, {0,1}, {0,-1}};
    public int numIslands(char[][] grid) {
        int row = grid.length;
        int col = grid[0].length;
        int res = 0;
        for (int i = 0; i < row; i++){
            for(int j = 0; j < col; j++){
                if(grid[i][j] == '1'){
                    dfs(grid, i, j);
                    res ++;
                }
            }
        }
        return res;

    }
    private void dfs(char[][] grid, int r, int c){
        if(r >= 0 && r < grid.length &&
           c >= 0 && c < grid[0].length &&
           grid[r][c] == '1'
        ){
            grid[r][c] = '0';
        }else{
            return;
        }

        for(int[] dir : dirs){
            dfs(grid, r+dir[0], c+dir[1]);
        }
    }
}
