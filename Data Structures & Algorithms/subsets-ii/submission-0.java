class Solution {
    List<List<Integer>> res = new ArrayList<>();
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);
        bt(nums, new ArrayList<>(), 0);
        return res;
    }
    private void bt(int[] nums, List<Integer> path,  int index){
        if(index <= nums.length){
            res.add(new ArrayList<>(path));
            if (index == nums.length) return;
        }
        for (int i = index; i < nums.length; i++){
            if(i > index && nums[i] == nums[i-1]) continue;
            path.add(nums[i]);
            bt(nums, path, i+1);
            path.remove(path.size()-1);
        }
        return;
    }
}
