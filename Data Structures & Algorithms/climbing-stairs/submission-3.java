class Solution {
    public int climbStairs(int n) {
        if(n <= 2) return n;
        int[] memo = new int[n+1];
        return dfs(n,memo);
    }


    private int dfs(int n, int[] memo){
        if(n <= 2) return n;

        if(memo[n] != 0) return memo[n];

        memo[n] = dfs(n-1, memo) + dfs(n-2, memo);

        return memo[n];
    }
}
