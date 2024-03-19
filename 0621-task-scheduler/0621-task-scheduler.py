from collections import defaultdict

class Solution:
    def leastInterval(self, tasks: List[str], n: int) -> int:
        task_map = defaultdict(int)
        for task in tasks:
            task_map[task] += 1
        
        task_q = []
        task_cd = []
        for task in task_map:
            heappush(task_q, (-task_map[task], task))
        
        intervals = 0
        while task_q or task_cd:
            while task_cd and task_cd[0][0] + (n+1) == intervals:
                cd, task = task_cd.pop()
                heappush(task_q, (-task_map[task], task))
            if task_q:
                amount_left, task = heappop(task_q)
                amount_left *= -1
                amount_left -= 1
                task_map[task] = amount_left
                if amount_left:
                    task_cd.append((intervals, task))
            
            intervals += 1
        
        return intervals