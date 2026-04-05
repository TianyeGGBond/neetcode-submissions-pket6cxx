class Solution {
    List<List<Integer>> res = new ArrayList<>();
    public List<List<Integer>> permute(int[] nums) {
        bt(nums, new ArrayList<>(), new boolean[nums.length]);
        return res;
    }
    private void bt(int[]nums, List<Integer> path, boolean[] visited){
        if(path.size() == nums.length){
            res.add(new ArrayList<>(path));
            return;//yaoxiema?
        }

        for(int i = 0; i < nums.length; i++){
            if(visited[i] == true) continue;
            path.add(nums[i]);
            visited[i] = true;
            bt(nums, path, visited);
            visited[i] = false;
            path.remove(path.size()-1);
        }
        return;
    }
}
