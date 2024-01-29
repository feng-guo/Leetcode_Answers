class Solution:
    def networkDelayTime(self, times: List[List[int]], n: int, k: int) -> int:
        time_map = {}
        edge_map = defaultdict(list)
        for edge in times:
            edge_map[edge[0]].append([edge[1], edge[2]])
        
        queue = []
        queue.append([k, 0])
        while len(queue) > 0:
            i, t = queue.pop(0)
            if i in time_map.keys() and t >= time_map[i]:
                continue
            else:
                for edge in edge_map[i]:
                    next_hop, next_time = edge
                    if next_hop not in time_map or time_map[next_hop] > t + next_time:
                        queue.append([next_hop, t + next_time])
            time_map[i] = t
                    
        
        if len(time_map.keys()) == n:
            time_max = 0
            for key in time_map:
                time_max = max(time_max, time_map[key])
            return time_max
        else:
            return -1
        
        
        