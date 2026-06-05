class Solution {
    int row, col;
    int[][] dirs = {{0, 1}, {0, -1}, {-1, 0}, {1,0}};
    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        if(heights == null) return null;
        this.row = heights.length;
        this.col = heights[0].length;
        boolean[][] pac = new boolean[row][col];
        boolean[][] atl = new boolean[row][col];
        // pacific -> mark true on visited arr
        for(int r = 0; r < row; r++){
            dfs(heights, r, 0, pac);
            dfs(heights, r, col-1, atl);
        }

        // atlantic -> mark true on visited arr
        for(int c = 0; c < col; c++){
            dfs(heights, 0, c, pac);
            dfs(heights, row-1, c, atl);
        }

        List<List<Integer>> res = new ArrayList<>();
        for(int i = 0; i < row; i++){
            for(int j = 0; j < col; j++){
                if(pac[i][j] && atl[i][j]){
                    res.add(Arrays.asList(i,j));
                } 
            }
        }
        return res;

    }
    
    private void dfs(int[][] heights, int r, int c, boolean[][] ocean){
        ocean[r][c] = true;

        for(int[] dir : dirs){
            int newR = r + dir[0];
            int newC = c + dir[1];
            if(newR < 0 || newR >= row || newC < 0 || newC >= col
                || ocean[newR][newC] || heights[newR][newC] < heights[r][c]){
                    continue;
            }
            dfs(heights, newR, newC, ocean);
        }
    }
}
