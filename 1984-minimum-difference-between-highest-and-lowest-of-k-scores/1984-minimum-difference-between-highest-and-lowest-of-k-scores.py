class Solution:
    def minimumDifference(self, nums: List[int], k: int) -> int:
        res = float("inf")
        nums.sort()
        for i in range(k-1, len(nums)):
            res = min(res, nums[i]-nums[i-(k-1)])
        return res