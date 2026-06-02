class Solution {

    public List<List<Integer>> combinationSum(int[] nums, int target) {
        HashSet<List<Integer>> res = new HashSet<>();
        List<Integer> path = new ArrayList<>();

        dfs(nums, 0, target, res, path);
        return new ArrayList<>(res);
    }
    private void dfs(int[] nums, int i, int remain, HashSet<List<Integer>> res, List<Integer> path){
        if(remain == 0){
            res.add(new ArrayList<>(path));
        }
        if(i >= nums.length || remain < 0) return;

        path.add(nums[i]);
        dfs(nums, i, remain - nums[i], res, path);
        path.remove(path.size() - 1);
        dfs(nums, i + 1, remain, res, path);
    }
}
