class Solution {
    private final int[][] dirs = {{1,0},{-1,0},{0,1},{0,-1}};
    public int longestIncreasingPath(int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;
        int[][] dp = new int[m][n];

        int max = 1;
        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                max = Math.max(max, dfs(i, j, matrix, dp));
                System.out.println(dp[i][j]);
            }
        }
        return max;
    }
    private int dfs(int x, int y, int[][] matrix, int[][] dp){
        if(dp[x][y] != 0) return dp[x][y];
        
        dp[x][y] = 1;
        for(int[] dir : dirs){
            int a = x + dir[0];
            int b = y + dir[1];
            if(a < 0 || a >= matrix.length || 
            b < 0 || b >= matrix[0].length ) continue;

            if(matrix[a][b] > matrix[x][y]){
                dp[x][y] = Math.max(dp[x][y], dfs(a, b, matrix, dp) + 1);
            }
        }
        return dp[x][y];
    }
}
