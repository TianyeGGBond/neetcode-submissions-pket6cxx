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
                if(!isPalin(s, start, i)) continue;

                path.add(s.substring(start, i));
                dfs(s, res, path, i);
                path.remove(path.size() - 1);
            }
        }
    
    private boolean isPalin(String s , int start, int end){
        if(end <= start) return false;

        String sub = s.substring(start, end);
        for(int i = 0; i <= sub.length()/2; i++){
            if(!(sub.charAt(i) == sub.charAt(sub.length()- 1 - i))){
                return false;
            }
        }
        return true;
    }
}
