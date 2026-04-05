class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        Arrays.sort(piles);

        int r = piles[piles.length-1];
        int l = 1;
        int t = 0;

        while(l < r){
            t =0;
            int mid = l + (r-l)/2;
            for(int p : piles){
                t += (p+ mid -1) / mid ;
            }
            
                if(t > h){
                    l = mid +1;
                }else{
                    r = mid;
                }
        }
        return l;
    }
}
