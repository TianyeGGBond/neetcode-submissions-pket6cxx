class Solution {
    private static int[][] dirs = {{1,0},{-1,0},{0,1},{0,-1}};
    int ROW;
    int COL;

    public int numIslands(char[][] grid) {
        ROW = grid.length;
        COL = grid[0].length;

        int res = 0;

        for(int i = 0; i < ROW; i++){
            for(int j = 0; j < COL; j++){
                if(grid[i][j] == '1'){
                    dfs(i, j , grid);
                    res++;
                }
            }
        }

        return res;
    }

    private void dfs(int i , int j , char[][] grid){
        if(i < 0 || i >= ROW ||j < 0 || j >= COL
            || grid[i][j] == '0'){
                return;
        }

        grid[i][j] = '0';

        for(int[] d : dirs){
            dfs(i + d[0], j + d[1], grid);
        }
        
    }
}
