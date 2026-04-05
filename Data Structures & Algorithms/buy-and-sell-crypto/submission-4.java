class Solution {
    public int maxProfit(int[] prices) {
        int n = prices.length;
        if(n == 0) return 0;

        int res = 0;

        int l = 0, r = 0, lmin = prices[0];
        while(r < n){
            if(prices[l] < prices[r]){
                lmin = Math.min(prices[l] , lmin);
                res = Math.max(res, prices[r] - lmin);
                l++;
            }else{
                l = r;
                r++;
            }
            System.out.println(lmin);
        }
        return res;
    }
}
