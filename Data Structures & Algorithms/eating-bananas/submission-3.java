class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        int len = piles.length;
        Arrays.sort(piles);

        int tryL = 1, tryR = piles[len -1] + 1;
        while(tryL < tryR){
            int tryM = tryL + (tryR - tryL) /2;

            // res < target
            if(hour(tryM, piles) >  h){
                tryL = tryM + 1;
            }else{
                tryR = tryM;
            }
        }

        return tryR;
    }

    private int hour(int eatRate, int[] piles){
        int count = 0;
        for(int bnn : piles){
            count += (bnn + eatRate - 1) / eatRate;
        }
        return count;
    }
}
