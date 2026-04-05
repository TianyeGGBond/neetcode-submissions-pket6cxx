class Solution {
    public int maxProfit(int[] prices) {
        // set a result container
        int res = 0;

        // new pointers
        int l = 0;
        int r = 1;

        // iterate array
       while(r < prices.length){
        int buy = prices[l];
        int sell = prices[r];
        int pf = sell - buy;

        if(pf > res) res = pf;

        if(buy > sell) l = r;

        r++;
       }
        // if res > 0, return res
        return res;
    }
}
