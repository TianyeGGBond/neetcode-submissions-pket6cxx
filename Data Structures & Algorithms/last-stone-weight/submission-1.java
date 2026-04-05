class Solution {
    public int lastStoneWeight(int[] stones) {
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>();
        for (int s : stones){
            maxHeap.offer(-s);
        }
        while(maxHeap.size()>1){
            int a = maxHeap.poll();
            int b = maxHeap.poll();
            maxHeap.offer(a-b);
        }
        
        return Math.abs(maxHeap.peek());
    }
}
