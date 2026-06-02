class Solution {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> path = new ArrayList<>();
        dfs(candidates, target, 0, res, path);
        return res;
    }

    private void dfs(int[] candidates, int target, 
    int start, List<List<Integer>> res, List<Integer> path){
        if(target == 0){
            res.add(new ArrayList<>(path));
        }
        if(target < 0 ) return;

        for(int i = start; i < candidates.length; i++){
            if(candidates[i] > target) return;
            if(i > start && candidates[i] == candidates[i-1]) continue;
        
            path.add(candidates[i]);
            dfs(candidates, target - candidates[i], i + 1, res, path);
            path.remove(path.size() - 1);
        }
    }
}
