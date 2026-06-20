class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        HashMap<Integer, List<Integer>> map = new HashMap<>();
        HashMap<Integer, Integer> indegree = new HashMap<>();

        // make graph
        for(int i = 0; i< numCourses; i++){
            map.put(i, new ArrayList<>());
            indegree.put(i,0);
        }

        for(int[] pair : prerequisites){
            int pre = pair[1];
            int cur = pair[0];
            map.get(pre).add(cur);
            indegree.put(cur, indegree.get(cur) + 1);
        }
//()
        int num = 0;
        Queue<Integer> q = new LinkedList<>();
        for(int key : indegree.keySet()){
            if(indegree.get(key) == 0){
                q.offer(key);
                num++;
            }
        }

        while(!q.isEmpty()){
            int cur = q.poll();
            if(map.get(cur) == null) continue;
            for(int next : map.get(cur)){
                indegree.put(next, indegree.get(next) -1);
                if(indegree.get(next) == 0){
                    q.offer(next);
                    num++;
                }
            }
        }

        return num == numCourses;
        
    }
}
