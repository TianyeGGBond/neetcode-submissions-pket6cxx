class Solution {
    Map<Integer, List<Integer>> map = new HashMap<>();

    public int[] findRedundantConnection(int[][] edges) {
        int n = edges.length;
        for (int i = 1; i <= n; i++) {
            map.put(i, new ArrayList<>());
        }

        for (int[] edge : edges) {
            int u = edge[0], v = edge[1];
            boolean[] visited = new boolean[n + 1];

            // 如果 u 和 v 已经连通，说明这条边是冗余边
            if (dfs(u, v, visited)) {
                return edge;
            }

            // 否则把这条边加入图
            map.get(u).add(v);
            map.get(v).add(u);
        }
        return new int[0];
    }

    private boolean dfs(int curr, int target, boolean[] visited) {
        if (curr == target) return true;
        visited[curr] = true;

        for (int neigh : map.get(curr)) {
            if (!visited[neigh]) {
                if (dfs(neigh, target, visited)) {
                    return true;
                }
            }
        }
        return false;
    }
}
