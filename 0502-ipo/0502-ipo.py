class Solution:
    def findMaximizedCapital(self, k: int, w: int, profits: List[int], capital: List[int]) -> int:
        projects = []
        for i in range(len(profits)):
            projects.append((capital[i], profits[i]))
        projects.sort()
        
        pq = []
        index = 0
        
        
        while k > 0:
            ## Add all things to the queue
            while index < len(projects) and projects[index][0] <= w:
                heappush(pq, -projects[index][1])
                index += 1
            if not pq:
                break
            w -= heappop(pq)
            k -= 1
                
        return w
        