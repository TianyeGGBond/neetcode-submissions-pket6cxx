class Solution {
    public int leastInterval(char[] tasks, int n) {
        int[] taskCount = new int[26];
        for(char c : tasks){
            taskCount[c - 'A'] ++;
        }

        // maxHeap for the max count task now
        Queue<Integer> pq = new PriorityQueue<>((a,b) -> Integer.compare(b,a));
        for(int i = 0; i < 26; i++){
            if(taskCount[i] == 0) continue;
            pq.offer(taskCount[i]);
        }
        
        Queue<int[]> queue = new LinkedList<>();
        int time = 0;
        while(!pq.isEmpty() || !queue.isEmpty()){
            time++;

            if(pq.isEmpty()) time = queue.peek()[1];
            else{
                int cur = pq.poll()-1;
                if(cur > 0){
                    queue.offer(new int[]{cur, time+n});
                }
            }

            
            if(!queue.isEmpty() && queue.peek()[1] == time){
                pq.offer(queue.poll()[0]);
            }

        }
        return time;
    }
}
