class Solution:
    def largestPerimeter(self, nums: List[int]) -> int:
        nums.sort()
        
        perimeter = sum(nums)
        
        for i, side in enumerate(nums[::-1]):
            if i == len(nums) - 2:
                return -1
            
            if side < perimeter - side:
                return perimeter
            else:
                perimeter -= side