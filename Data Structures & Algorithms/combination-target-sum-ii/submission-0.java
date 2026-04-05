class Solution {
    List<List<Integer>> res = new ArrayList<>();
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);
        bt(new ArrayList<>(), candidates, target, 0);
        return res;
    }
    private void bt(List<Integer> path, int[] candidates, int target, int index){
        if (target == 0){
            res.add(new ArrayList<>(path));
            return;
        }
        if(index == candidates.length) return;

        for (int i = index; i < candidates.length; i++){
            if(i > index && candidates[i] == candidates[i-1]) continue;

            path.add(candidates[i]);
            bt(path, candidates, target-candidates[i], i+1);
            path.remove(path.size()-1);
        }
        return;
        
    }
}
