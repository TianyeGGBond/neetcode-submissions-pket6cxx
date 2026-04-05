class Solution {
    List<List<Integer>> res;
    public List<List<Integer>> subsets(int[] nums) {
        res = new ArrayList<>();
        List<Integer> path = new ArrayList<>();
        dfs(nums, 0, path);
        return res; 
    }
    public void dfs(int[] nums, int i, List<Integer> path){
        if(i == nums.length){
            res.add(new ArrayList<>(path));
            return;
        }

        path.add(nums[i]);
        dfs(nums, i + 1, path);

        path.remove(path.size()-1);
        dfs(nums, i + 1, path);
    }
}
