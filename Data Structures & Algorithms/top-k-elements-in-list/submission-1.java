class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer,Integer> fre = new HashMap<>();
        for(int n : nums){
            fre.put(n, fre.getOrDefault(n,0) + 1);
        }
        PriorityQueue<int[]> pq 
            = new PriorityQueue<>((a,b) -> a[1]-b[1]);
        for(int key: fre.keySet()){
            pq.offer(new int[]{key, fre.get(key)});
            if(pq.size() > k) pq.poll();
        }
        int[] res = new int[k];
        for(int i = 0; i < k; i++){
            res[i] = pq.poll()[0];
        }
        return res;

    }
}
