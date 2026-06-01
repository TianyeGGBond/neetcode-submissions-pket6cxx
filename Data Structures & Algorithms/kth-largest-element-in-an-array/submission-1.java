class Solution {
    public int findKthLargest(int[] nums, int k) {
        if(nums == null || k > nums.length) return -1;
        Queue<Integer> pq = new PriorityQueue<>();
        for(int num : nums){
            pq.offer(num);
            if(pq.size() > k) pq.poll();
        }
        return pq.peek();
    }
}
