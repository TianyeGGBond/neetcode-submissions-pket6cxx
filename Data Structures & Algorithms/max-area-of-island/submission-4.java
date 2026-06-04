class Solution {
    private int area = 0;
    private int maxArea = 0;
    private int row;
    private int col;
    private int[][] dirs = {{0,1}, {0,-1}, {1,0}, {-1,0}};

    public int maxAreaOfIsland(int[][] grid) {
        this.row = grid.length;
        this.col = grid[0].length;

        for(int i = 0; i < row; i++){
            for(int j = 0; j < col; j++){
                if(grid[i][j] == 1){
                    this.area = 0;
                    dfs(grid, i , j);
                    maxArea = Math.max(area, maxArea);
                }
            }
        }

        return maxArea;
    }

    private void dfs(int[][] grid, int r, int c){
        // range check
        if(r < 0 || r >= row || c < 0 || c >= col){
            return;
        }

        //water/0 check
        if(grid[r][c] == 0) return;

        //drain
        area++;
        grid[r][c] = 0;

        //4 dirs
        for(int[] dir : dirs){
            int newR = r + dir[0];
            int newC = c + dir[1];
            dfs(grid, newR, newC);
        }
    }
}
