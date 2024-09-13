class Solution:
    def xorQueries(self, arr: List[int], queries: List[List[int]]) -> List[int]:
        current = 0
        
        cache = []
        cache.append(0)
        res = []
        
        for num in arr:
            current ^= num
            cache.append(current)
        
        for query in queries:
            left, right = query
            res.append(cache[left] ^ cache[right+1])
        
        return res