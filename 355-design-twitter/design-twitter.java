class Twitter {

        // Implement the below functions.
        HashMap<Integer, HashSet<Integer>> following;
        HashMap<Integer, ArrayList<Tweet>> tweets;

        Twitter() {
            following = new HashMap<>();
            tweets = new HashMap<>();
        }

        public void postTweet(int userId, int tweetId) {
            if (!tweets.containsKey(userId)) {
                tweets.put(userId, new ArrayList<>());
                following.put(userId, new HashSet<>(List.of(userId)));
            }
            Tweet tweet = new Tweet(tweetId);
            tweets.get(userId).add(tweet);
            //System.out.println(tweetId + " " + tweet.time);
        }

        public List<Integer> getNewsFeed(int userId) {
            List<Integer> newsFeed = new ArrayList<>();
            PriorityQueue<Tweet> pq = new PriorityQueue<>((a, b) -> b.time - a.time);

            if (tweets.containsKey(userId)) {
                HashSet<Integer> hs = following.get(userId);
                for (int id : hs) {
                    int n = 0;
                    ArrayList<Tweet> t = tweets.get(id);
                    while (n < t.size()) {
                        pq.add(t.get(n));
                        n++;
                    }
                }
                int n = 0;
                while (!pq.isEmpty() && n < 10) {
                    newsFeed.add(pq.poll().tweetId);
                    n++;
                }
            }
            return newsFeed;
        }

        public void follow(int followerId, int followeeId) {
            if (!following.containsKey(followerId)) {
                tweets.put(followerId, new ArrayList<>());
                following.put(followerId, new HashSet<>(List.of(followerId)));
            }
            if (!following.containsKey(followeeId)) {
                tweets.put(followeeId, new ArrayList<>());
                following.put(followeeId, new HashSet<>(List.of(followeeId)));
            }
            following.get(followerId).add(followeeId);
        }

        public void unfollow(int followerId, int followeeId) {
            if (following.containsKey(followerId) && following.get(followerId).contains(followeeId)) {
                following.get(followerId).remove(followeeId);
            }
        }
}

class Tweet {
    public static int timeStamp = 0;
        int tweetId;
        int time;

        Tweet(int tId) {
            tweetId = tId;
            time = timeStamp++;
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