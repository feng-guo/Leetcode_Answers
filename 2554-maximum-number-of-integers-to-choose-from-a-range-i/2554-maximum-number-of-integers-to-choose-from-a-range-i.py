class Solution:
    def maxCount(self, banned: List[int], n: int, maxSum: int) -> int:
        banned = set(banned)
        
        current_sum = 0
        res = 0
        
        for i in range(1, n+1):
            if i not in banned:
                current_sum += i
                res += 1
            if current_sum + i >= maxSum:
                break
        
        return res