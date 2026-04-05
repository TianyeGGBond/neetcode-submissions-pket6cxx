class Solution {
    LinkedList<String> res = new LinkedList<>();
    Map<String, PriorityQueue<String>> map = new HashMap<>();

    public List<String> findItinerary(List<List<String>> tickets) {
       
       for(List<String> t : tickets){
        map.computeIfAbsent(t.get(0),k -> new PriorityQueue<>()).offer(t.get(1));
       }
       dfs("JFK");
       return res;
    }

    private void dfs(String from ){
        if(map.containsKey(from)){
            PriorityQueue<String> heap = map.get(from);
            while(!heap.isEmpty()){
                String to = heap.poll();
                dfs(to);
            }
        }
        res.addFirst(from);
    }
}
