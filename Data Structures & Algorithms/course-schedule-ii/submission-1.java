class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        Map<Integer, List<Integer>> graph = new HashMap<>();
        int[] ind = new int[numCourses];

        for(int[] p : prerequisites){
            int course = p[0];
            int pre = p[1];
            graph.computeIfAbsent(pre, x -> new ArrayList<>()).add(course);
            ind[course]++;
        }

        Queue<Integer> q = new LinkedList<>();
        for(int i = 0; i < numCourses; i++){
            if (ind[i] == 0) q.offer(i);
        }

        int[] res = new int[numCourses];
        int count = 0;

        while(!q.isEmpty()){
            int cur = q.poll();
            res[count] = cur;
            count++;
            // -- after ind
            if(graph.containsKey(cur)){
                for(int after : graph.get(cur)){
                    ind[after] --;
                    if(ind[after] == 0) q.offer(after);
                }
            }
        }
        if(count < numCourses) return new int[0];
        return res;
    }
}
