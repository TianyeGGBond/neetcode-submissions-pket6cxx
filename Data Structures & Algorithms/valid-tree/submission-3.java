class Solution {
    public boolean validTree(int n, int[][] edges) {
        if(edges.length != n-1) return false;

        HashMap<Integer, List<Integer>> graph = new HashMap<>();
        for(int i = 0; i < n; i++){
            graph.put(i, new ArrayList<>());
        }

        for(int[] e : edges){
            int a = e[0];
            int b = e[1];
            graph.get(a).add(b);
            graph.get(b).add(a);
        }

        Queue<Integer> q = new LinkedList<>();
        boolean[] visited = new boolean[n];
        int count = 0;

        q.offer(0);
        visited[0] = true;

        while(!q.isEmpty()){
            int cur = q.poll();
            count++;
            visited[cur] = true;
            for(int next : graph.get(cur)){
                if(!visited[next]){
                    q.offer(next);
                }
            }
        }

        return count == n;
    }
}
