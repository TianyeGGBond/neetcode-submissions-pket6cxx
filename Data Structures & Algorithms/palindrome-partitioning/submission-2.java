class Solution {
    public List<List<String>> partition(String s) {
        List<List<String>> res = new ArrayList<>();
        List<String> path = new ArrayList<>();
        
        dfs(s, res, path, 0);
        
        return res;
    }

    private void dfs(String s, List<List<String>> res, 
        List<String> path, int start){
            if(start == s.length()){
                res.add(new ArrayList<>(path));
                return;
            }

            for(int i = start+1; i <= s.length(); i++){
                // i exclusive
                if(!isPalin(s, start, i)) continue;

                path.add(s.substring(start, i));
                dfs(s, res, path, i);
                path.remove(path.size() - 1);
            }
        }
    
    private boolean isPalin(String s , int start, int end){
        int left = start;
        int right = end - 1;

        while(left < right){
            if(s.charAt(left) != s.charAt(right)){
                return false;
            }
            left++;
            right--;
        }
        return true;
    }
}
