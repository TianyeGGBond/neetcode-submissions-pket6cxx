class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        List<Integer> path = new ArrayList<>();
        HashMap<Integer, List<Integer>> graph = new HashMap<>();
        HashMap<Integer, Integer> indegree = new HashMap<>();

        for(int i = 0; i< numCourses; i++){
            graph.put(i, new ArrayList<>());
            indegree.put(i, 0);
        }

        for(int[] pair : prerequisites){
            int pre = pair[1];
            int next = pair[0];
            graph.get(pre).add(next);
            indegree.put(next, indegree.get(next) + 1);
        }

        Queue<Integer> q = new LinkedList<>();
        for(int key: indegree.keySet()){
            if(indegree.get(key) == 0){
                q.add(key);
            }
        }

        while(!q.isEmpty()){
            int cur = q.poll();
            path.add(cur);
            for(int next : graph.get(cur)){
                indegree.put(next, indegree.get(next) - 1);
                if(indegree.get(next) == 0){
                    q.offer(next);
                }
            }
        }

        if(path.size() == numCourses){
            int[] res = new int[numCourses];

            for(int i = 0; i < numCourses; i++){
                res[i] = path.get(i);
            }

            return res;
        }
        return new int[0];
    }
}
