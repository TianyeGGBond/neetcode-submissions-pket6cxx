class TimeMap {
    HashMap<String, List<Integer>> map_name;
    HashMap<String, String> map_val;

    public TimeMap() {
        map_name = new HashMap<>();
        map_val  = new HashMap<>();
    }
    
    public void set(String key, String value, int timestamp) {
        map_name.putIfAbsent(key, new ArrayList<>());
        map_name.get(key).add(timestamp);

        StringBuilder key_tran = new StringBuilder(key);
        String time_tran = String.valueOf(timestamp);

        key_tran.append("@").append(time_tran);
        map_val.put(key_tran.toString(), value);
    }
    
    public String get(String key, int timestamp) {
        if(!map_name.containsKey(key)) return "";

        int target_ts = -1;
        List<Integer> ls = map_name.get(key);
        target_ts = findTarget(ls, timestamp);
        if(target_ts == -1) return "";

        StringBuilder key_tran_get = new StringBuilder(key);
        String time_tran_get = String.valueOf(target_ts);

        key_tran_get.append("@").append(time_tran_get);
        return map_val.get(key_tran_get.toString());

    }

    private int findTarget(List<Integer> ls, int target){
        int len = ls.size();
        int l = 0, r = len;

        while(l < r){
            int mid = l + (r - l )/2;
            if(ls.get(mid) > target){
                r = mid;
            }else{
                l = mid + 1;
            }
        }

        return l > 0 ? ls.get(l-1) : -1;
    }
}
