class Solution:
    def removeDuplicates(self, nums: List[int]) -> int:
        prev = float("inf")
        prev_count = 0
        place_index = 0
        for num in nums:
            if num == prev and prev_count == 2:
                continue
            else:
                nums[place_index] = num
                place_index += 1
                if prev == num:
                    prev_count += 1
                else:
                    prev_count = 1
                prev = num
                
                
        return place_index