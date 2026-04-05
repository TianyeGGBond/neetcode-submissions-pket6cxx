class Solution {
    List<List<Integer>> res = new ArrayList<>();
    public List<List<Integer>> subsets(int[] nums) {
        List<Integer> path = new ArrayList<>();
        backtrack(path, nums, 0);
        return res;
    }
    private void backtrack(List<Integer> path, int[] nums, int n){

        res.add(new ArrayList<>(path));

        if(n == nums.length) return;

        for(int i = n; i < nums.length; i++){
            path.add(nums[i]);
            backtrack(path, nums, i+1);
            path.remove(path.size()-1);
        }
        return;
    }
}
