
class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        for(int cur: nums){
            map.put(cur, map.getOrDefault(cur, 0)+1);
        }

        PriorityQueue<int[]> q = new PriorityQueue<>((a,b) -> (a[0]- b[0]));

        for(int key : map.keySet()){
            int val = map.get(key);
            q.offer(new int[]{val, key});
            if(q.size() > k){
                q.poll();
            }
        }

        int[] res = new int[k];

        for(int i = 0; i < k; i++){
            res[i] = q.poll()[1];
        }

        return res;
    }
}
