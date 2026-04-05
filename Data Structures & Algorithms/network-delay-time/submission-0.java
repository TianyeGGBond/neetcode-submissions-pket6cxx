class Solution {
    Queue<int[]> heap = new PriorityQueue<>((a,b) -> a[0]-b[0]);
    Map<Integer, List<int[]>> map = new HashMap<>();

    public int networkDelayTime(int[][] times, int n, int k) {
        //adj map
        for(int[] time : times){
            int from = time[0];
            int to = time[1];
            int t = time[2];
            map.putIfAbsent(from, new ArrayList<>());
            map.get(from).add(new int[]{t,to});
        }
        //minheap generating
        heap.offer(new int[]{0,k});
        Set<Integer> visited = new HashSet<>();
        int res = 0;
        while(!heap.isEmpty()){
            //min cost node
            int[] cur = heap.poll();
            int node = cur[1];
            int t = cur[0];
            if(visited.contains(node)) continue;
            visited.add(node);
            res = t;
            if(map.containsKey(node)){
                for(int[] nei : map.get(node)){
                    if(!visited.contains(nei[1])){
                        heap.offer(new int[]{t + nei[0], nei[1]});
                    }
                }
            }
            
        }
        return visited.size() == n ? res : -1;
    }
}
