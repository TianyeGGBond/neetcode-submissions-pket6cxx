class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int m = matrix.length;
        int n = matrix[0].length;

        if(target < matrix[0][0] || target > matrix[m-1][n-1]) return false;
        
        //target in which row
        int up = 0;
        int down = m - 1;
        while(up <= down){
            int mid = up + (down - up) /2;
            if(matrix[mid][0] < target){
                up = mid + 1;
            }else if(matrix[mid][0] > target){
                down = mid -1;
            }else{
                return true;
            }
        }
        int row = down;

        //target in while col
        int l = 0;
        int r = n -1;
        while(l <= r){
            int mid = l + (r-l) /2;
            if(matrix[row][mid] < target){
                l = mid + 1;
            }else if(matrix[row][mid] > target){
                r = mid -1;
            }else{
                return true;
            }
        }
        return false;
    }
}
