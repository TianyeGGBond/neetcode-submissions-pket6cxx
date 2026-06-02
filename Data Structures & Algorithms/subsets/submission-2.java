class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        if(nums == null) return null;
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> path = new ArrayList<>();
        dfs(nums, 0, res, path);
        return res;
    }

    private void dfs(int[] nums, int i, List<List<Integer>> res, List<Integer> path){
        if(i >= nums.length){
            res.add(new ArrayList<>(path));
            return;
        }
        path.add(nums[i]);
        dfs(nums, i + 1, res, path);
        path.remove(path.size() - 1);
        dfs(nums, i + 1, res, path);
    }
}
