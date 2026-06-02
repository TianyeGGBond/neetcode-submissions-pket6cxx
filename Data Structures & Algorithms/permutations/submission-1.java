class Solution {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> path = new ArrayList<>();
        boolean[] used = new boolean[nums.length];
        dfs(nums, res, path, used);
        return res;
    }

    private void dfs(int[] nums, List<List<Integer>> res,  List<Integer> path, boolean[] used){
        if(path.size() == nums.length){
            res.add(new ArrayList<>(path));
        }

        for(int i = 0; i < nums.length; i++){
            if(used[i]) continue;

            path.add(nums[i]);
            used[i] = true;
            dfs(nums, res, path, used);

            path.remove(path.size() - 1);
            used[i] = false;
        }
    }
}
