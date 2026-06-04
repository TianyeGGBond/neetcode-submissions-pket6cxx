class Solution {

    private int row;
    private int col;
    private int[][] dirs = {{0,1}, {0,-1}, {1,0}, {-1,0}};

    public int maxAreaOfIsland(int[][] grid) {
        this.row = grid.length;
        this.col = grid[0].length;
        int maxArea = 0;

        for(int i = 0; i < row; i++){
            for(int j = 0; j < col; j++){
                if(grid[i][j] == 1){
                    int area = dfs(grid, i , j);
                    maxArea = Math.max(area, maxArea);
                }
            }
        }

        return maxArea;
    }

    private int dfs(int[][] grid, int r, int c){
        // range check
        if(r < 0 || r >= row || c < 0 || c >= col){
            return 0;
        }

        //water/0 check
        if(grid[r][c] == 0) return 0;

        //drain
        grid[r][c] = 0;
        int area = 1;

        //4 dirs
        for(int[] dir : dirs){
            int newR = r + dir[0];
            int newC = c + dir[1];
            area += dfs(grid, newR, newC);
        }
        return area;
    }
}
