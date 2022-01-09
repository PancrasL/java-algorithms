package indi.pancras.labuladuo.design;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Set;

public class Twitter355 {
    class Twitter {
        class User {
            int userId;
            Set<User> fans;
            Set<User> follows;
            LinkedList<Tweet> tweets;

            public User(int userId) {
                this.userId = userId;
                fans = new HashSet<>();
                follows = new HashSet<>();
                tweets = new LinkedList<>();
            }

            public Iterator<Tweet> getIterator() {
                return tweets.iterator();
            }
        }

        class Tweet {
            int userId;
            int tweetId;
            int time;

            public Tweet(int userId, int tweetId, int time) {
                this.userId = userId;
                this.tweetId = tweetId;
                this.time = time;
            }
        }

        HashMap<Integer, User> userMap;
        int time = 0;

        public Twitter() {
            userMap = new HashMap<>();
        }

        public void postTweet(int userId, int tweetId) {
            User user = userMap.computeIfAbsent(userId, e -> new User(userId));
            user.tweets.addFirst(new Tweet(userId, tweetId, time++));
        }

        public List<Integer> getNewsFeed(int userId) {
            if (!userMap.containsKey(userId)) {
                return new ArrayList<>(0);
            }
            PriorityQueue<Tweet> queue = new PriorityQueue<>(((o1, o2) -> o2.time - o1.time));
            User user = userMap.get(userId);
            List<Iterator<Tweet>> tweetsList = new ArrayList<>();
            tweetsList.add(user.getIterator());
            for (User follow : user.follows) {
                tweetsList.add(follow.getIterator());
            }
            List<Integer> ans = new ArrayList<>();
            List<Iterator<Tweet>> needToDelete = new ArrayList<>();
            while (true) {
                for (Iterator<Tweet> it : tweetsList) {
                    if (it.hasNext()) {
                        queue.add(it.next());
                    } else {
                        needToDelete.add(it);
                    }
                }
                tweetsList.removeAll(needToDelete);
                needToDelete.clear();
                if (queue.isEmpty()) {
                    break;
                }
                ans.add(queue.poll().tweetId);
                if(ans.size() == 10){
                    break;
                }
            }
            return ans;
        }

        public void follow(int followerId, int followeeId) {
            User follower = userMap.computeIfAbsent(followerId, u -> new User(followerId));
            User followee = userMap.computeIfAbsent(followeeId, u -> new User(followeeId));
            follower.follows.add(followee);
            followee.fans.add(follower);
        }

        public void unfollow(int followerId, int followeeId) {
            User follower = userMap.computeIfAbsent(followerId, u -> new User(followerId));
            User followee = userMap.computeIfAbsent(followeeId, u -> new User(followeeId));
            follower.follows.remove(followee);
            followee.fans.remove(follower);
        }
    }
}
