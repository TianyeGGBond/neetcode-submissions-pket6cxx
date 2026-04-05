class Solution {
    public int maxProfit(int[] prices) {
        int n = prices.length;
        int res = 0;

        //two pointers, if l > r , l will go to r
        // int l = 0, r = 0, min = 0;
        // while(r < n){
        //     if(prices[l] < prices[r]){
        //         res = Math.max(res, prices[r] - prices[l]);
        //     }else{
        //         l = r;
        //     }
        //     r++;
        // }
        // return res;

        //go through arr, record min
        int min = prices[0];
        for(int p : prices){
            min = Math.min(min, p);
            res = Math.max(res, p-min);
        }
        return res;
    }
}
