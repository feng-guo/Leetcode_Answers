class Solution:
    def findErrorNums(self, nums: List[int]) -> List[int]:
        
        check_dupe = set()
        dupe = 0
        
        for n in nums:
            if n not in check_dupe:
                check_dupe.add(n)
            else:
                dupe = n
                break
        
        check_dupe = set(nums)
        
        for i in range(1, len(nums)+1):
            if i not in check_dupe:
                return [dupe, i]
        