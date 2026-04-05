class Solution {
    Map<Integer, List<Integer>> map = new HashMap<>();
    Set<Integer> visited = new HashSet<>();
    int count = 0;
    public int countComponents(int n, int[][] edges) {
        for(int i = 0; i < n; i++){
            map.put(i, new ArrayList<>());
        }
        for(int[] edge : edges){
            map.get(edge[0]).add(edge[1]);
            map.get(edge[1]).add(edge[0]);
        }
        for(int i = 0; i < n; i++){
            if (visited.contains(i)) continue;
            count++;
            dfs(i);
        }
        
        return count;
    }
    private void dfs(int x){
        if(visited.contains(x)) return;
        visited.add(x);
            for(int nei : map.get(x)){
                dfs(nei);
            }
    }
}
