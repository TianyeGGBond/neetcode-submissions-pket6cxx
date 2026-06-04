class Solution {
    public void islandsAndTreasure(int[][] grid) {
        // find all the tressure
        Queue<int[]> queue = new LinkedList<>();

        for(int i= 0; i < grid.length; i++){
            for(int j = 0; j < grid[0].length; j++){
                if(grid[i][j] == 0){
                    queue.offer(new int[]{i, j});
                }
            }
        }

        int step = 0;
        int[][] dirs = {{0,1}, {0, -1}, {1,0}, {-1,0}};

        //pop the current source then add step
        while(!queue.isEmpty()){
            //pop the node
            int[] cur = queue.poll();

            //parse coordinates
            int r = cur[0];
            int c = cur[1];

            //iternate its neighbors
            for(int[] dir : dirs){
                int newR = r + dir[0];
                int newC = c + dir[1];

                if(newR < 0 || newR >= grid.length || newC < 0 || newC >= grid[0].length //TODO
                    || grid[newR][newC] != 2147483647){
                    continue;
                }
                grid[newR][newC] = grid[r][c] + 1;
                queue.offer(new int[]{newR, newC});
            }
        }
    }
}
