class Solution {
    public int lastStoneWeight(int[] stones) {
        if(stones == null) return 0;

        Queue<Integer> pq = new PriorityQueue<>((a,b) -> b-a);
        for(int stone : stones){
            pq.offer(stone);
        }

        while(pq.size() > 1){
            int y = pq.poll();
            int x = pq.poll();
            if(x < y) pq.offer(y-x);
        }

        return pq.isEmpty() ? 0 : pq.peek(); 
    }
}
