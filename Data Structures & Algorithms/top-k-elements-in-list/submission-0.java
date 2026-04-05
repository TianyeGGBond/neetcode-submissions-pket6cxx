class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer,Integer> fre = new HashMap<>();
        for(int n : nums){
            fre.put(n, fre.getOrDefault(n,0) + 1);
        }
        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b) -> b[1]-a[1]);
        for(int key: fre.keySet()){
            pq.offer(new int[]{key, fre.get(key)});
        }
        int[] res = new int[k];
        for(int i = 0; i < k; i++){
            res[i] = pq.poll()[0];
        }
        return res;

    }
}
