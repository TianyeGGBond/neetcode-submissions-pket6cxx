class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        int[] indegree = new int[numCourses];
        List<List<Integer>> graph = new ArrayList<>();
        for(int i = 0; i < numCourses; i++){
            graph.add(new ArrayList<>());
        }

        for(int[] pair : prerequisites){
            int pre = pair[1];
            int cur = pair[0];
            graph.get(pre).add(cur);
            indegree[cur]++;
        }

        Queue<Integer> queue = new LinkedList<>();

        for(int i = 0; i < numCourses; i++){
            if(indegree[i] == 0) queue.offer(i);
        }

        int count = 0;

        while(!queue.isEmpty()){
            int course = queue.poll();
            count++;
            List<Integer> nexts = graph.get(course);
            for(int next : nexts){
                indegree[next]--;
                if(indegree[next] == 0){
                    queue.offer(next);
                }
            }
        }
        return count == numCourses;
    }
}
