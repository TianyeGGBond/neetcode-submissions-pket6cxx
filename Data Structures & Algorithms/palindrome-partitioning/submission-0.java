class Solution {
    List<List<String>> res = new ArrayList<>();
    List<String> path = new ArrayList<>();
    public List<List<String>> partition(String s) {
       bt(s,0);
       return res;
    }
    private void bt(String s, int i){
        if(i == s.length()){
            res.add(new ArrayList<>(path));
            return;
        }
        for (int j = i; j < s.length(); j++){
            if(pali(s,i,j)){
                path.add(s.substring(i,j+1));
                bt(s, j+1);
                path.remove(path.size()-1);
            }
        }
        return;
    }
    private boolean pali(String s , int i, int j){

        if(i > j || s.charAt(i) != s.charAt(j)) return false;

        if(i == j) return true;
        if(i+1 == j && s.charAt(i) == s.charAt(j)) return true;

        return pali(s, i+1, j-1);
    }
}
