class Solution:
    def numOfMinutes(self, n: int, headID: int, manager: List[int], informTime: List[int]) -> int:
        tree = defaultdict(set)
        for i, e_id in enumerate(manager):
            tree[e_id].add(i)
        
        def dfs(root):
            if not tree[root]:
                # no employees to inform
                return 0
            else:
                time = 0
                for e_id in tree[root]:
                    time = max(time, dfs(e_id))
                return time + informTime[root]
        
        return dfs(headID)
                