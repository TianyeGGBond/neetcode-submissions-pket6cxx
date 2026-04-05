class Solution {
    List<String> res = new ArrayList<>();
    Map<Character, String> map = new HashMap<>();

    public List<String> letterCombinations(String digits) {
        map.put('2',"abc");
        map.put('3',"def");
        map.put('4',"ghi");
        map.put('5',"jkl");
        map.put('6',"mno");
        map.put('7',"pqrs");
        map.put('8',"tuv");
        map.put('9',"wxyz");
        if(digits == null || digits == "") return res;
        dfs(digits, 0, new StringBuilder());
        return res;

    }
    private void dfs(String digits, int i, StringBuilder path){
        if(i == digits.length()){
            res.add(new StringBuilder(path).toString());
            return;
        }
        String cur = map.get(digits.charAt(i));
        for(char c : cur.toCharArray()){
            path.append(c);
            dfs(digits, i+1, path);
            path.deleteCharAt(path.length()-1);
        }
        return;
    }
}
