class Solution {

    private int[][] dirs = {{1,0}, {0,1}, {-1,0}, {0,-1}};
    private int row = 0;
    private int col = 0;
    
    public int numIslands(char[][] grid) {
        this.row = grid.length;
        this.col = grid[0].length;
        int res = 0;

        for(int i = 0; i < row; i++){
            for(int j = 0; j < col; j++){
                if(grid[i][j] == '1') res++;
                dfs(grid, i, j);
            }
        }

        return res;
    }
    
    private void dfs(char[][] grid, int r, int c){
        // range check
        if(r < 0 || r >= row || c < 0 || c >= col){
            return;
        }

        // water check(0)
        if(grid[r][c] == '0'){
            return;
        }
        grid[r][c] = '0';

        //dfs
        for(int[] dir : dirs){
            int newR = r + dir[0];
            int newC = c + dir[1];
            dfs(grid, newR, newC);
        }
    }
}
