import math

class Solution:
    def increasingTriplet(self, nums: List[int]) -> bool:
        min_n = None
        second_min = None
        
        for num in nums:
            if min_n == None or num < min_n:
                min_n = num
            elif (second_min == None and num > min_n) or (second_min != None and min_n < num < second_min):
                second_min = num
            if second_min != None and num > second_min:
                return True
            
            
        return False
        