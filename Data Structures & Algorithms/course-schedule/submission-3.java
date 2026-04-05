class Solution {
    Map<Integer, List<Integer>> map = new HashMap<>();
    Set<Integer> visiting = new HashSet<>();

    public boolean canFinish(int numCourses, int[][] prerequisites) {
        for(int i = 0; i < numCourses; i++){
            map.put(i, new ArrayList<>());
        }
        for(int[] pre : prerequisites){
            map.get(pre[0]).add(pre[1]);
        }
        for(int i = 0; i < numCourses; i++){
            if(!dfs(i)) return false;
        }
        return true;
    }
    private boolean dfs(int n){
        //circle detected
        if(visiting.contains(n)) return false;
        //empty
        if(map.get(n).isEmpty()) return true;
        //!dfs pre
        visiting.add(n);
        for(int pre : map.get(n)){
            if(!dfs(pre)) return false;
        }
        visiting.remove(n);
        map.put(n, new ArrayList<>());
        return true;
    }
}
