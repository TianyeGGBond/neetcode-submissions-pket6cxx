class Solution {
    public int lastStoneWeight(int[] stones) {
        // initial maxheap
        PriorityQueue<Integer> p = new PriorityQueue<>((a,b) -> b-a);
        for(int s : stones){
            p.offer(s);
        }

        while(p.size() >= 2){
            int cur1 = p.poll();
            int cur2 = p.poll();
            if(cur1 > cur2) p.offer(cur1-cur2);
        }

        p.offer(0);
        return p.peek();
    }
}
