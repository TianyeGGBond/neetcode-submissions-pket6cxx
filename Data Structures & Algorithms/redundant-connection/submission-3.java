class Solution {
    
    public int[] findRedundantConnection(int[][] edges) {
        int[] parent = new int[edges.length + 1];
        for(int i = 0; i <= edges.length; i++){
            parent[i] = i;
        }

        for(int[] edge : edges){
            if(!union(parent, edge[0], edge[1])) return edge;
        }
        return new int[0];
    }
}
    private int find(int[] parent, int n){
        if(parent[n] != n) parent[n] = find(parent, parent[n]);
        return parent[n];
    }

    private boolean union(int[] parent, int u, int v){
        if(find(parent, u) == find(parent, v)) return false;
        parent[find(parent, u)] = find(parent, v);
        return true;
    }
