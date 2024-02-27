import math

class Solution:
    def findPeakElement(self, nums: List[int]) -> int:
        l = 0
        r = len(nums)-1
        while(l<=r):
            m = (l+r)//2
            mid = nums[m]
            left = -math.inf
            right = -math.inf
            if (m > 0):
                left = nums[m-1]
            if (m < len(nums)-1):
                right = nums[m+1]
            if left < mid and mid > right:
                return m
            if left < mid < right:
                l = m+1
            else:
                r = m-1
        