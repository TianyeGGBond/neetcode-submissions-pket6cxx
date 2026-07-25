class Solution {
    public int networkDelayTime(int[][] times, int n, int k) {
        // build graph
        HashMap<Integer, List<int[]>> map = new HashMap<>();
        for(int i = 1 ; i <= n; i++){
            map.put(i, new ArrayList<>());
        }
        for(int[] p : times){
            // [distance, next]
            int[] next = new int[]{p[2],p[1]};
            map.get(p[0]).add(next);
        }

        //build minheap
        PriorityQueue<int[]> minHeap = new PriorityQueue<>(
            (a,b) -> Integer.compare(a[0], b[0]));
        minHeap.offer(new int[]{0, k});
        Set<Integer> set = new HashSet<>();

        int time = 0;
        int visited = 0;
        while(visited < n && !minHeap.isEmpty()){
            
            int[] temp = minHeap.poll();
            int cur = temp[1];
            if(set.contains(cur)) continue;
            set.add(cur);
            visited++;
            time = temp[0];

            for(int[] next : map.get(cur)){
                minHeap.offer(new int[]{next[0] + time, next[1]});
            }
        }
        return visited == n? time : -1;
    }
}
