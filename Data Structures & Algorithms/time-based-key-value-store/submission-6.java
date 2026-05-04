class TimeMap {
    HashMap<String, List<Pair>> map_name;

    public TimeMap() {
        map_name = new HashMap<>();
    }
    
    public void set(String key, String value, int timestamp) {
        map_name.putIfAbsent(key, new ArrayList<>());
        map_name.get(key).add(new Pair(timestamp, value));
    }
    
    public String get(String key, int timestamp) {
        if(!map_name.containsKey(key)) return "";
        List<Pair> ls = map_name.get(key);
        return findTarget(ls, timestamp);
    }
    
    class Pair{
        int time;
        String val;

        Pair(int time, String val){
            this.time = time;
            this.val = val;
        }
    }

    private String findTarget(List<Pair> ls, int target){
        int len = ls.size();
        int l = 0, r = len;

        while(l < r){
            int mid = l + (r - l )/2;
            if(ls.get(mid).time > target){
                r = mid;
            }else{
                l = mid + 1;
            }
        }

        return l > 0 ? ls.get(l-1).val : "";
    }

}
