class Solution {
    public int trap(int[] height) {
        int n = height.length;
        int[] l = new int[n];
        int[] r = new int[n];

        l[0] = 0;
        r[n-1] = 0;

        for(int i = 1; i < n; i++){
            l[i] = Math.max(l[i-1], height[i-1]);
        }
        for(int i = n-2; i > 0; i--){
            r[i] = Math.max(r[i+1], height[i+1]);
        }

        int res = 0;
        for(int i = 0; i < n; i++){
            res += Math.max((Math.min(l[i], r[i]) - height[i]), 0);
        }

        return res;
    }
}
