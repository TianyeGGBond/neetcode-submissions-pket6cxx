class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        int[] indegree = new int[numCourses];
        List<List<Integer>> graph = new ArrayList<>();
        for(int i = 0; i < numCourses; i++){
            graph.add(new ArrayList<>());
        }

        for(int[] pair : prerequisites){
            int pre = pair[1];
            int cour = pair[0];
            graph.get(pre).add(cour);
            indegree[cour]++;
        }

        Queue<Integer> queue = new LinkedList<>();
        for(int i = 0; i < numCourses; i++){
            if(indegree[i] == 0) queue.offer(i);
        }

        int count = 0;
        int[] path = new int[numCourses];

        while(!queue.isEmpty()){
            int cur = queue.poll();
            path[count] = cur;
            count++;
            
            for(int next : graph.get(cur)){
                indegree[next]--;
                if(indegree[next] == 0){
                    queue.offer(next);
                }
            }
        }

        return count == numCourses ? path : new int[0];
    }
}
