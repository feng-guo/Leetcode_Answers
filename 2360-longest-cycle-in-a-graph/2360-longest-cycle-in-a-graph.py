class Solution:
    def longestCycle(self, edges: List[int]) -> int:
        res = -1
        
        for i in range(len(edges)):
            current = i
            traversed = {}
            count = 0
            while current != -1:
                if current not in traversed:
                    traversed[current] = count
                else:
                    res = max(res, count - traversed[current])
                    break
                next_node = edges[current]
                count += 1
                edges[current] = -1
                current = next_node
        
        return res
        