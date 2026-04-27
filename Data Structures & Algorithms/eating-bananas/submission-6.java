class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        int maxBnn = 0;
        for(int bnn : piles){
            maxBnn = Math.max(bnn, maxBnn);
        }

        int tryL = 1, tryR = maxBnn + 1;
        while(tryL < tryR){
            int tryM = tryL + (tryR - tryL) /2;

            if(hour(tryM, piles, h)){
                tryR = tryM ;
            }else{
                tryL = tryM + 1;
            }
        }

        return tryL;
    }

    private boolean hour(int eatRate, int[] piles, int h){
        int count = 0;
        for(int bnn : piles){
            count += (bnn + eatRate - 1) / eatRate;
        }
        return count <= h;
    }
}
// lower bound 最小的 k，使得 hour(k) <= h

// if (mid 已经满足条件) {
//     r = mid;
// } else {
//     l = mid + 1;
// }
