class Solution:
    def largestAltitude(self, gain: List[int]) -> int:
        
        max_height = 0
        current = 0
        
        for num in gain:
            current += num
            max_height = max(max_height, current)
        
        return max_height
        