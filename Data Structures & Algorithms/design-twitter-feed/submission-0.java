class Twitter {
    class Tweet {
        int id;
        int userId;
        int tweetId;

        public Tweet(int id, int tweetId, int userId){
            this.id=id;
            this.tweetId=tweetId;
            this.userId=userId;
        }
    }

    int timestamp =0;
    Map<Integer, Set<Integer>> followerMap = new HashMap<>(); //userId: followerId
    Map<Integer, List<Tweet>> tweetsMap = new HashMap<>();//userId: tweets

    public Twitter() {
        
    }
    
    public void postTweet(int userId, int tweetId) {
        Tweet newTweet = new Tweet(timestamp++, tweetId, userId);
        
        if(!tweetsMap.containsKey(userId)){
            tweetsMap.put(userId, new ArrayList<>());
        }
        tweetsMap.get(userId).add(newTweet);
    }
    
    public List<Integer> getNewsFeed(int userId) {
        PriorityQueue<Tweet> feed = new PriorityQueue<>((a,b) -> b.id - a.id );
        //retrieve all user and follower tweets and add them into the priority queue.

        Set<Integer> following = new HashSet<>();

        Set<Integer> followerIds = followerMap.getOrDefault(userId, new HashSet<>()); 
        following.addAll(followerIds);
        following.add(userId);

        for(Integer follower : following){
            List<Tweet> userPosts = tweetsMap.getOrDefault(follower, List.of());
            for(Tweet tweet : userPosts){
                feed.offer(tweet);
            }
        }

        List<Integer> userFeed = new ArrayList<>();
        int count = 0;
        while(!feed.isEmpty() && count < 10){
            userFeed.add(feed.poll().tweetId);
            count++;
        }

        return userFeed;
    }
    
    public void follow(int followerId, int followeeId) {
        if(!followerMap.containsKey(followerId)){
            followerMap.put(followerId, new HashSet<>());
        }

        followerMap.get(followerId).add(followeeId);
    }
    
    public void unfollow(int followerId, int followeeId) {
        if(!followerMap.containsKey(followerId)){
            followerMap.put(followerId, new HashSet<>());
        }

        followerMap.get(followerId).remove(followeeId);

    }
}


/**
 * Your Twitter object will be instantiated and called as such:
 * Twitter obj = new Twitter();
 * obj.postTweet(userId,tweetId);
 * List<Integer> param_2 = obj.getNewsFeed(userId);
 * obj.follow(followerId,followeeId);
 * obj.unfollow(followerId,followeeId);
 */