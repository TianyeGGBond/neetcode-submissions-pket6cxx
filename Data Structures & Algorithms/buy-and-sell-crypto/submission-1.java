class Solution {
    public int maxProfit(int[] prices) {

        int res = 0;
        int min_p = prices[0];

        for( int p : prices){
            if(p < min_p){
                min_p = p;
            }
            res = Math.max(p - min_p, res);
        }
        return res;
    }
}
