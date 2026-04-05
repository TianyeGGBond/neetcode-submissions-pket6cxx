class Twitter {
    private int time;
    private Map<Integer, Set<Integer>> follow;
    private Map<Integer, List<int[]>> tweet;
    
    public Twitter() {
        this.time = 0;
        follow = new HashMap<>();
        tweet = new HashMap<>();
    }
    
    public void postTweet(int userId, int tweetId) {
        if(!tweet.containsKey(userId)){
            tweet.put(userId, new ArrayList<>());
        }
        tweet.get(userId).add(new int[]{time, tweetId});
        time++;
    }
    
    public List<Integer> getNewsFeed(int userId) {
        PriorityQueue<int[]> minHeap = new PriorityQueue<>((a,b) -> Integer.compare(b[0],a[0]));
        List<Integer> res = new ArrayList<>();

        if(!follow.containsKey(userId)) follow.put(userId, new HashSet<>());
        follow.get(userId).add(userId);

        for(int followee : follow.get(userId)){
            if (tweet.containsKey(followee)){
                List<int[]> tweetList = tweet.get(followee);
                int index = tweetList.size() - 1;
                int[] tweetCur = tweetList.get(index);
                minHeap.offer(new int[]{tweetCur[0], tweetCur[1], followee, index});
            }
        }
        while(res.size() < 10 && !minHeap.isEmpty()){
            int[] cur = minHeap.poll();
            res.add(cur[1]);
            if (cur[3] > 0){
                List<int[]> tweetList = tweet.get(cur[2]);
                int[] tweetCur = tweetList.get(cur[3] - 1);
                minHeap.offer(new int[]{tweetCur[0], tweetCur[1], cur[2], cur[3] - 1});
            }
        }
        return res;
    } 
    
    public void follow(int followerId, int followeeId) {
        if(!follow.containsKey(followerId)){
            follow.put(followerId, new HashSet<>());
        }
        follow.get(followerId).add(followeeId);
    }
    
    public void unfollow(int followerId, int followeeId) {
        if(!follow.containsKey(followerId) || !follow.get(followerId).contains(followeeId)){
            return;
        }
        follow.get(followerId).remove(followeeId);
    }
}
