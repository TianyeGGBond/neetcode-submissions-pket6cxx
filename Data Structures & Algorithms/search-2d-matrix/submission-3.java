class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int m = matrix.length;
        int n = matrix[0].length;
        if(target > matrix[m-1][n-1] || target < matrix[0][0]) return false;

        int l = 0;
        int r = m-1;
        int row = 0;
        while(l <= r){
            int mid = l + (r-l)/2;
            if(target > matrix[mid][0]) {
                row = mid;
                l = mid+1;
                }
            else if(target < matrix[mid][0]) r = mid-1;
            else return true;
        }

        int cl = 0;
        int cr = n-1;
        while(cl < cr){
            int cmid = cl + (cr - cl)/2;
            if(matrix[row][cmid] == target) return true;
            else if(matrix[row][cmid] > target) cr = cmid -1;
            else cl = cmid + 1;
        }
        return matrix[row][cl] == target;

    }
}
