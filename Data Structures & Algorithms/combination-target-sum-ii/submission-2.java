class Solution {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> path = new ArrayList<>();
        boolean[] memo = new boolean[candidates.length];
        dfs(candidates, target, 0, res, path, memo);
        return res;
    }

    private void dfs(int[] candidates, int target, int i, List<List<Integer>> res, List<Integer> path, boolean[] memo){
        if(target == 0){
            res.add(new ArrayList<>(path));
            return;
        }
        if(i >= candidates.length || target < 0) return;

        if(i > 0 && candidates[i-1] == candidates[i] && !memo[i-1]){
            dfs(candidates, target, i+1, res, path, memo);
        }else{
            path.add(candidates[i]);
            memo[i] = true;
            dfs(candidates, target - candidates[i], i+1, res, path, memo);

            path.remove(path.size() - 1);
            memo[i] = false;
            dfs(candidates, target, i+1, res, path, memo);
        }
    }
}
