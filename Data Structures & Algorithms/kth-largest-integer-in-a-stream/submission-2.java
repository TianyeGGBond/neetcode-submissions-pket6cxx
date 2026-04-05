class KthLargest {
    List<Integer> ls;
    int k;

    public KthLargest(int k, int[] nums) {
        this.k = k;
        ls = new ArrayList<>();
        // initial list
        for(int num : nums){
            ls.add(num);
        }
    }
    
    public int add(int val) {
        ls.add(val);
        // build minheap
        PriorityQueue<Integer> p = new PriorityQueue<>();
        for(int num : ls){
            p.offer(num);
            if(p.size() > k){
                p.poll();
            }
        }
        return p.peek();
    }
}
