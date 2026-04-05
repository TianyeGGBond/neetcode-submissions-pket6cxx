class Solution {
    public int maxArea(int[] heights) {
        int res = 0;
        int n = heights.length;
        int l = 0;
        int r = n-1;

        while(l < r){
            int h = Math.min(heights[l], heights[r]);
            res = Math.max(h*(r-l), res);
            if(h == heights[l]) l++;
            else r--;
        }
        return res;
    }
}
