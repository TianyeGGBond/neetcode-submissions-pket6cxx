class Solution {
    List<List<Integer>> res = new ArrayList<>();

    public List<List<Integer>> combinationSum(int[] nums, int target) {
        List<Integer> path = new ArrayList<>();
        bt(path, nums, target, 0);
        return res;
    }
    private void bt(List<Integer> path, int[]nums, int n, int index){
        if(n == 0){
            res.add(new ArrayList<>(path));
        }else if(n <2 || index == nums.length){
            return;
        }
        for(int i = index; i < nums.length; i++ ){
            path.add(nums[i]);
            bt(path, nums, n - nums[i], i);
            path.remove(path.size() - 1);
        }
        return;
    }
}
