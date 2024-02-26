from collections import defaultdict

class Solution:
    def findAllPeople(self, n: int, meetings: List[List[int]], firstPerson: int) -> List[int]:
        visited = {}
        meetings_map = defaultdict(set)
        for meeting in meetings:
            meetings_map[meeting[0]].add((meeting[1], meeting[2]))
            meetings_map[meeting[1]].add((meeting[0], meeting[2]))
        
        queue = []
        queue.append((0, 0))
        heappush(queue, (0, firstPerson))
        while queue:
            time, person = heappop(queue)
            if person in visited:
                continue
            visited[person] = time
            for meeting in meetings_map[person]:
                other, mt = meeting
                if other not in visited and mt >= time:
                    heappush(queue, (mt, other))
                    
        return list(visited.keys())
                
        