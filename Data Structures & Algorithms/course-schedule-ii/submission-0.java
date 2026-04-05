class Solution {
    Map<Integer, List<Integer>> map = new HashMap<>();
    Set<Integer> visited = new HashSet<>();
    Set<Integer> circle = new HashSet<>();
    List<Integer> path = new ArrayList<>();

    public int[] findOrder(int numCourses, int[][] prerequisites) {
        for(int i = 0; i < numCourses; i++){
            map.put(i, new ArrayList<>());
        }
        for(int[] pre : prerequisites){
            map.get(pre[0]).add(pre[1]);
        }
        for(int i = 0; i < numCourses; i++){
            if(!dfs(i)) return new int[0];
        }
        int[] res = new int[numCourses];
        for(int i = 0; i < numCourses; i++){
            res[i] = path.get(i);
        }
        return res;
    }
    private boolean dfs(int n ){
        if(circle.contains(n)) return false;
        if(visited.contains(n)) return true;
        circle.add(n);
        for(int pre: map.get(n)){
            if(!dfs(pre)) return false;
        }
        circle.remove(n);
        path.add(n);
        visited.add(n);
        return true;
    }
    
}
