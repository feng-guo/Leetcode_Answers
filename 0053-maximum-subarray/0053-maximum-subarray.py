class Solution(object):
    def maxSubArray(self, nums):
        """
        :type nums: List[int]
        :rtype: int
        """
        max = float('-inf')
        sum = 0
        for i in nums:
            if sum < 0:
                sum = i
            else:
                sum += i
            if sum > max:
                max = sum
        return max
        