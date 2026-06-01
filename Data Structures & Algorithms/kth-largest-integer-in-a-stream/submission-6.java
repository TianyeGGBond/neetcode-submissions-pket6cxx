class KthLargest {
    Queue<Integer> pq;
    int k;

    public KthLargest(int k, int[] nums) {
        this.k = k;
        pq = new PriorityQueue<>();
        if(nums == null) return;

        for(int num : nums){
            pq.offer(num);
        }
        return;
    }
    
    public int add(int val) {
        pq.offer(val);
        while(pq.size() > k) pq.poll();
        return pq.peek();
    }
}
