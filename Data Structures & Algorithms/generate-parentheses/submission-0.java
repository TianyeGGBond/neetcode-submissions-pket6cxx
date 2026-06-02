class Solution {
    public List<String> generateParenthesis(int n) {
        List<String> res = new ArrayList<>();
        StringBuilder path = new StringBuilder();
        boolean[] used = new boolean[2*n];
        char[] chars = new char[2*n];

        for(int i = 0; i < n; i++){
            chars[i] = '(';
            chars[n+i] = ')';
        }
        
        dfs(chars, used, path, res, 0);

        return res;
    }

    private void dfs(char[] chars, boolean[] used, 
    StringBuilder path, List<String> res, int can){
        if(can < 0) return;
        if(path.length() == chars.length){
            StringBuilder temp = new StringBuilder(path);
            res.add(temp.toString());
            return;
        }

        for(int i = 0; i < chars.length; i++){
            if(used[i]) continue;
            if(i > 0 && chars[i] == chars[i-1] && !used[i-1]) continue;

            path.append(chars[i]);
            used[i] = true;
            if(chars[i] == '(') can++;
            else can--;

            dfs(chars, used, path, res, can);

            path.deleteCharAt(path.length() - 1);
            used[i] = false;
            if(chars[i] == '(') can--;
            else can++;
        }
    }
}
