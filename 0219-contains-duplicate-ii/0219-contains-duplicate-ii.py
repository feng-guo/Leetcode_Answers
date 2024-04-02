class Solution:
    def containsNearbyDuplicate(self, nums: List[int], k: int) -> bool:
        dupes = set()
        
        for i, num in enumerate(nums):
            if i >= k+1:
                dupes.remove(nums[i-k-1])
            if num in dupes:
                return True
            dupes.add(num)
        
        return False