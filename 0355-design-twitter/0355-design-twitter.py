class Twitter:
    def __init__(self):
        self.count = 0
        self.tweet_map = defaultdict(list)
        self.follow_map = defaultdict(set)

    def postTweet(self, userId: int, tweetId: int) -> None:
        self.tweet_map[userId].append([self.count, tweetId])
        self.count += 1

    def getNewsFeed(self, userId: int) -> List[int]:
        pointer_map = {}
        pointer_map[userId] = len(self.tweet_map[userId]) - 1
        for followeeId in self.follow_map[userId]:
            pointer_map[followeeId] = len(self.tweet_map[followeeId]) - 1
        added = 0
        res = []
        while added < 10:
            most_recent = float('-inf')
            most_recent_tweet_id = float('-inf')
            most_recent_user_id = float('-inf')
            for user_id in pointer_map.keys():
                if pointer_map[user_id] < 0:
                    continue
                elif self.tweet_map[user_id][pointer_map[user_id]][0] > most_recent:
                    most_recent = self.tweet_map[user_id][pointer_map[user_id]][0]
                    most_recent_tweet_id = self.tweet_map[user_id][pointer_map[user_id]][1]
                    most_recent_user_id = user_id
            if most_recent != float('-inf'):
                res.append(most_recent_tweet_id)
                pointer_map[most_recent_user_id] -= 1
                added += 1
            else:
                return res
        return res
        

    def follow(self, followerId: int, followeeId: int) -> None:
        self.follow_map[followerId].add(followeeId)

    def unfollow(self, followerId: int, followeeId: int) -> None:
        self.follow_map[followerId].discard(followeeId)
        


# Your Twitter object will be instantiated and called as such:
# obj = Twitter()
# obj.postTweet(userId,tweetId)
# param_2 = obj.getNewsFeed(userId)
# obj.follow(followerId,followeeId)
# obj.unfollow(followerId,followeeId)