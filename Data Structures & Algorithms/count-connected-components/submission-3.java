class Solution {
    public int countComponents(int n, int[][] edges) {
        Union uf = new Union(n);

        for(int[] pair : edges){
            uf.union(pair[0], pair[1]);
        }

        return uf.count;
    }
}

class Union{
    int[] parent;
    int[] rank;
    int count;

    public Union(int n){
        parent = new int[n];
        rank = new int[n];
        count = n;

        for(int i = 0; i< n; i++){
            parent[i] = i;
        }
    }

    public int find(int n){
        if(parent[n] != n){
            parent[n] = find(parent[n]);
        }
        return parent[n];
    }

    public void union(int a, int b){
        int aRoot = find(a);
        int bRoot = find(b);

        if(aRoot == bRoot) return;

        count--;
        if(rank[a] < rank[b]){
            parent[aRoot] = bRoot; 
        }else if(rank[a] > rank[b]){
            parent[bRoot] = aRoot;
        }else{
            parent[aRoot] = bRoot;
            rank[b]++;
        }

        return;
    }
}
