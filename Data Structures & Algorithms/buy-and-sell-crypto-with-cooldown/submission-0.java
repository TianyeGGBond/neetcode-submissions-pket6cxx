class Solution {
    public int maxProfit(int[] prices) {
        int len = prices.length;
        if(len <= 1) return 0;
        int[] hold = new int[len];
        int[] sold = new int[len];
        int[] cold = new int[len];
        hold[0] = - prices[0];
        sold[0] = 0;
        cold[0] = 0;//no stock, no action
        for(int i = 1; i < len; i++){
            hold[i] = Math.max(hold[i-1], cold[i-1] - prices[i]);
            sold[i] = hold[i-1] + prices[i];
            cold[i] = Math.max(cold[i-1], sold[i-1]);
        }
        return Math.max(sold[len-1], cold[len-1]);
    }
}
