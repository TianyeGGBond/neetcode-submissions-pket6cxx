class Solution {

    public List<List<Integer>> combinationSum(int[] nums, int target) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> path = new ArrayList<>();

        dfs(nums, 0, target, res, path);
        return new ArrayList<>(res);
    }
    private void dfs(int[] nums, int i, int remain, List<List<Integer>> res, List<Integer> path){
        if(remain == 0){
            res.add(new ArrayList<>(path));
            return;
        }
        if(i >= nums.length || remain < 0) return;

        path.add(nums[i]);
        dfs(nums, i, remain - nums[i], res, path);
        path.remove(path.size() - 1);
        dfs(nums, i + 1, remain, res, path);
    }
}
