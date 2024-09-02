class Solution:
    def chalkReplacer(self, chalk: List[int], k: int) -> int:
        sum_chalk = sum(chalk)
        
        k = k%sum_chalk
        
        for i, c in enumerate(chalk):
            k -= c
            if k < 0:
                return i
        
        return -1
        