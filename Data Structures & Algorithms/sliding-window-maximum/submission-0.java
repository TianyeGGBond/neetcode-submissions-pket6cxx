class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        int n = nums.length;
        int[] res = new int[n-k+1];

        PriorityQueue<int[]> q = new PriorityQueue<>((a,b) -> b[0] - a[0]);
        int l = 0;
        for(int r = 0; r < n; r++){
            q.offer(new int[]{nums[r] , r});
            if(r - l + 1 > k) l++;

            if(r >= k - 1){
                while(q.peek()[1] < l) q.poll();
                res[r-k+1] = q.peek()[0];
            }
        }
        return res;
    }
}
