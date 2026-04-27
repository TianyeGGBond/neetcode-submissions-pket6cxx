class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        int len = piles.length;
        Arrays.sort(piles);

        int tryL = 1, tryR = piles[len -1] + 1;
        while(tryL < tryR){
            int tryM = tryL + (tryR - tryL) /2;

            if(hour(tryM, piles) <= h){
                tryR = tryM ;
            }else{
                tryL = tryM + 1;
            }
        }

        return tryL;
    }

    private int hour(int eatRate, int[] piles){
        int count = 0;
        for(int bnn : piles){
            count += (bnn + eatRate - 1) / eatRate;
        }
        return count;
    }
}
