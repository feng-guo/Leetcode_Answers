class Solution:
    def rotate(self, nums: List[int], k: int) -> None:
        """
        Do not return anything, modify nums in-place instead.
        """
        k = k % len(nums)
        if len(nums) == 1:
            return
        for i in range(len(nums)):
            end = len(nums) - 1 - i
            if end < i:
                break
            nums[i], nums[end] = nums[end], nums[i]
        for i in range(k):
            end = k - 1 - i
            if end < i:
                break
            nums[i], nums[end] = nums[end], nums[i]
        for i in range(k, len(nums)):
            end = len(nums) - 1 - (i-k)
            if end < i:
                break
            nums[i], nums[end] = nums[end], nums[i]