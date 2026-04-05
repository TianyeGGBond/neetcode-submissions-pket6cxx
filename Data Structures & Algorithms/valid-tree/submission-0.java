class Solution {
    Map<Integer, List<Integer>> map = new HashMap<>();
    Set<Integer> visited = new HashSet<>();
    Set<Integer> circle = new HashSet<>();
    public boolean validTree(int n, int[][] edges) {
        for(int i = 0; i < n; i++){
            map.put(i, new ArrayList<>());
        }
        for(int[] edge : edges){
            map.get(edge[0]).add(edge[1]);
            map.get(edge[1]).add(edge[0]);
        }
        if(!dfs(0, -1)) return false;
        return visited.size() == n;
    }
    private boolean dfs(int x, int parent){
        if(circle.contains(x)) return false;
        circle.add(x);
        for(int nei : map.get(x)){
            if (nei == parent) continue;
            if(!dfs(nei,x)) return false;
        }
        visited.add(x);
        circle.remove(x);
        return true;
    }
    
}
