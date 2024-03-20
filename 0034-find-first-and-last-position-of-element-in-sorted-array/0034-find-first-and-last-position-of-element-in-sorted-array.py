class Solution:
    
    
    def searchRange(self, nums: List[int], target: int) -> List[int]:
        first = -1
        last = -1
        
        left = 0
        right = len(nums) -1
        
        def searchFirst(nums, left, right, target):
            while left <= right:
                mid = (left+right) // 2
                if nums[mid] != target:
                    left = mid + 1
                else:
                    if mid - 1 < 0 or nums[mid - 1] != target:
                        return mid
                    else:
                        right = mid-1
                
        
        def searchLast(nums, left, right, target):
            while left <= right:
                mid = (left+right) // 2
                if nums[mid] != target:
                    right = mid - 1
                else:
                    if mid + 1 == len(nums) or nums[mid + 1] != target:
                        return mid
                    else:
                        left = mid + 1
        
        while left <= right:
            mid = (left+right) // 2
            if nums[mid] == target:
                first = searchFirst(nums, left, mid, target)
                last = searchLast(nums, mid, right, target)
                return [first, last]
            elif nums[mid] < target:
                left = mid + 1
            else:
                right = mid - 1       
        
        return [first, last]
        