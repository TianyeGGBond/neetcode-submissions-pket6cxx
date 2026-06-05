class Solution {
    public boolean validTree(int n, int[][] edges) {
        if(edges.length != n - 1) return false;

        List<List<Integer>> graph = new ArrayList<>();
        for(int i = 0; i < n; i++){
            graph.add(new ArrayList<>());
        }

        for(int[] pair : edges){
            int first = pair[0];
            int sec = pair[1];
            graph.get(first).add(sec);
            graph.get(sec).add(first);
        }

        boolean[] visited = new boolean[n];
        dfs(edges, visited, graph, 0);

        for(boolean v : visited){
            if( v == false) return false;
        }
        return true;
    }

    private void dfs(int[][] edges, boolean[] visited, List<List<Integer>> graph, int node){
        if(visited[node]) return;

        visited[node] = true;

        for(int next : graph.get(node)){
            if(visited[next]) continue;
            dfs(edges, visited, graph, next);
        }
    }
}
