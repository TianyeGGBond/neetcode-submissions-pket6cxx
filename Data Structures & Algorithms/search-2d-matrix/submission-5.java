class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int m = matrix.length, n = matrix[0].length;

        int up = 0, down = m;
        while(up < down){
            int mid = up + (down - up) / 2;
            if(matrix[mid][0] > target){
                down = mid;
            }else{
                up = mid + 1;
            }
        }
        int row = up - 1;
        if(row < 0) return false;

        int l = 0, r = n;
        while(l < r){
            int mid = l + (r - l )/2;
            if(matrix[row][mid] > target){
                r = mid;
            }else{
                l = mid + 1;
            }
        }

        return (l>= 1 && matrix[row][l-1] == target) ? true : false;
    }
}
