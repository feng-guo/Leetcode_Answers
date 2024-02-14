class Solution:
    def canPartition(self, nums: List[int]) -> bool:
        target = sum(nums)
        if target % 2 == 1:
            return False
        target = int(target/2)
        
        sums = set()
        
        for x in nums:
            current = list(sums)
            for y in current:
                new = x+y
                if new == target:
                    return True
                sums.add(new)
            sums.add(x)
            if x == target:
                return True
        
        return False
        
        