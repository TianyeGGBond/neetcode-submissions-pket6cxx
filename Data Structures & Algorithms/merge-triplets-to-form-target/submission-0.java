class Solution {
    public boolean mergeTriplets(int[][] triplets, int[] target) {
        boolean ok1 = false;
        boolean ok2 = false;
        boolean ok3 = false;

        for(int[] t : triplets){
            if(t[0] > target[0] ||
               t[1] > target[1] ||
               t[2] > target[2]){
                continue;
            }
               if(t[0] == target[0]) ok1 = true;
               if(t[1] == target[1]) ok2 = true;
               if(t[2] == target[2]) ok3 = true;
        }
        return ok1&&ok2&&ok3;
    }
}
