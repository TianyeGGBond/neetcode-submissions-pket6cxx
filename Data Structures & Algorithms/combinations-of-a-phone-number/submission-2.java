class Solution {
    String[] strs = {
        "", "", "abc","def","ghi",
        "jkl", "mno","pqrs","tuv","wxyz"
    };
    public List<String> letterCombinations(String digits) {
        List<String> res = new ArrayList<>();
        StringBuilder path = new StringBuilder();
        if(digits.length() == 0) return res;

        dfs(digits, res, path, 0);

        return res;
    }

    private void dfs(String digits, List<String> res,
    StringBuilder path, int start){

        if(start == digits.length()){
            res.add(path.toString());
            return;
        }

        int idx = Integer.parseInt(digits.substring(start, start+1));
        String str = strs[idx];

        for(int i = 0; i < str.length(); i++){
            path.append(str.charAt(i));
            dfs(digits, res, path, start+1);
            path.deleteCharAt(path.length() - 1);
        }
        
    }
}
