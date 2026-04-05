class Solution {
    public boolean isNStraightHand(int[] hand, int groupSize) {
        if(hand.length % groupSize != 0) return false;

        Arrays.sort(hand);
        Map<Integer, Integer> map = new HashMap<>();
        for(int h : hand){
            map.put(h, map.getOrDefault(h,0) + 1);
        }
        for(int h : hand){
            if(map.get(h) == 0) continue;
            int x = map.get(h); // 次数
            for(int i = 0; i < x; i++){
                for(int next = h; next < h + groupSize; next++){
                if(!map.containsKey(next) ||
                map.get(next) == 0) return false;
                map.put(next, map.get(next) - 1);
                }
            }
        }
        return true;
    }
}
