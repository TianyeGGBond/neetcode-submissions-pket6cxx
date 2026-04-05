class Solution {
    private static final int[][] dirs = {{1,0},{-1,0},{0,1},{0,-1}};

    List<List<Integer>> res = new ArrayList<>();
    int rows, cols;

    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        this.rows = heights.length;
        this.cols = heights[0].length;
        boolean[][] pacificFlow = new boolean[rows][cols];
        boolean[][] atlanticFlow = new boolean[rows][cols];

        for(int i = 0; i < cols; i++) dfs(heights, pacificFlow, 0, i);
        for(int i = 0; i < rows; i++) dfs(heights, pacificFlow, i, 0);
        for(int i = 0; i < cols; i++) dfs(heights, atlanticFlow, rows - 1, i);
        for(int i = 0; i < rows; i++) dfs(heights, atlanticFlow, i, cols - 1);

        for(int i = 0; i < rows; i++){
            for(int j = 0; j < cols; j++){
                if(pacificFlow[i][j] && atlanticFlow[i][j]){
                    res.add(Arrays.asList(i,j));
                }
            }
        }
        return res;
    }
    private void dfs(int[][] heights, boolean[][] flow, int r, int c){
        if(flow[r][c]) return;
        
        flow[r][c] = true;

        for(int[] dir : dirs){
            int nr = r + dir[0];
            int nc = c + dir[1];
            if (nr >= 0 && nr < rows &&
                nc >= 0 && nc < cols &&
                heights[r][c] <= heights[nr][nc]){
                dfs(heights, flow, nr, nc);
            }
        }
    }
}
