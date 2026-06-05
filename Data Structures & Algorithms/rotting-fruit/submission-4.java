class Solution {
    public int orangesRotting(int[][] grid) {
        //collect rotten
        Queue<int[]> queue = new LinkedList<>();
        int fresh = 0;

        for(int i = 0; i< grid.length; i++){
            for(int j = 0; j < grid[0].length; j++){
                if(grid[i][j] == 2) queue.offer(new int[]{i, j});
                else if(grid[i][j] == 1) fresh++;
            }
        }
        if(fresh == 0) return 0;

        int min = -1;
        int[][] dirs = {{0,1}, {0, -1}, {-1,0}, {1,0}};

        //poll rotten
        while(!queue.isEmpty()){
            int size = queue.size();
            for(int s = 0; s < size; s++){
                int[] cur = queue.poll();
                int r = cur[0];
                int c = cur[1];

                //affect neighbor
                for(int[] dir : dirs){// TODO
                    int newR = r + dir[0];
                    int newC = c + dir[1];
                    //check bounds + banana 1 TODO
                    if(newR < 0 || newR >= grid.length || newC < 0 || newC >=grid[0].length
                    || grid[newR][newC] != 1){
                        continue;
                    }
                    grid[newR][newC] = 2;
                    fresh--;
                    queue.offer(new int[]{newR, newC});
                }
            }
            //add mins TODO
            min++;
        }
        //exam remain
        return fresh == 0 ? min : -1;
    }
}
