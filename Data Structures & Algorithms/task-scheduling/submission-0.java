//621
class Solution {
    public int leastInterval(char[] tasks, int n) {
        int[] arr = new int[26];
        for (char c : tasks){
            arr[c -'A']++;
        }

        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());
        for(int c : arr){
            if(c > 0) maxHeap.offer(c);
        }

        Queue<int[]> waiting = new LinkedList<>();
        int time = 0;
        while(!maxHeap.isEmpty() || !waiting.isEmpty()){
            time++;
            if(!maxHeap.isEmpty()){
                int cur = maxHeap.poll() - 1;
                if(cur != 0) waiting.offer(new int[]{cur, time + n});
                if(!waiting.isEmpty() &&time == waiting.peek()[1]) maxHeap.offer(waiting.poll()[0]);
            }else{
                time = waiting.peek()[1];
                maxHeap.offer(waiting.poll()[0]);
            }
        }
        return time;
    }
}
