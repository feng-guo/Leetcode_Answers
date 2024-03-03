class Solution:
    def sortedSquares(self, nums: List[int]) -> List[int]:
        res = []
        n = 0
        for i, num in enumerate(nums):
            n = i
            if num >= 0:
                break
        
        decrease = n - 1
        increase = n
        
        for i in range(len(nums)):
            neg = float('inf')
            pos = float('inf')
            if decrease >= 0:
                neg = nums[decrease]
            if increase < len(nums):
                pos = nums[increase]
            if (abs(neg) < pos):
                decrease -= 1
                res.append(neg**2)
            else:
                increase += 1
                res.append(pos**2)
                
        return res
        