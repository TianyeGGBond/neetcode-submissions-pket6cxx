class Solution {
    public void islandsAndTreasure(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        Queue<int[]> q = new LinkedList<>();
        
        for(int i = 0; i < m;i++){
            for(int j = 0; j < n; j++){
                if(grid[i][j] == 0){
                    q.offer(new int[]{i,j});
                }
            }
        }

        int[][] dirs = {{1,0}, {0,1}, {-1,0}, {0,-1}};

        while(!q.isEmpty()){
            int size = q.size();

            for(int i = 0; i< size; i++){
                int[] cur = q.poll();

                for(int[] dir : dirs){
                    int newI = cur[0] + dir[0];
                    int newJ = cur[1] + dir[1];
                    if(newI < 0 || newI >= m || newJ <0 || newJ >= n || 
                    grid[newI][newJ] != Integer.MAX_VALUE ) continue;

                    grid[newI][newJ] = grid[cur[0]][cur[1]] + 1;
                    q.offer(new int[]{newI, newJ});
                }
            }
        }
    }
}
