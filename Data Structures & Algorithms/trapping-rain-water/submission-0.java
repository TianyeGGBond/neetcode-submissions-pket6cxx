class Solution {
    public int trap(int[] height) {
        if(height == null || height.length == 0) return 0;
        int n = height.length;
        int l = 0;
        int r = n-1;
        int maxl = height[l];
        int maxr = height[r];
        int res = 0;
        while(l < r){
            if(maxl < maxr){
                l++;
                maxl = Math.max(maxl, height[l]);
                res += maxl - height[l];
            }else{
                r--;
                maxr = Math.max(maxr, height[r]);
                res += maxr - height[r];
            }
        }
        return res;
    }
}
