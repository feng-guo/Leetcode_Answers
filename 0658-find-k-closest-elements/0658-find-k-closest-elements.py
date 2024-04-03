class Solution:
    def findClosestElements(self, arr: List[int], k: int, x: int) -> List[int]:
        res = []
        index = -1
        for i, num in enumerate(arr):
            if num >= x:
                index = i
                break
        if index == -1:
            index = len(arr) - 1
        
        l = index-1
        r = index
        
        while len(res) < k:
            left = float('-inf')
            right = float('inf')
            if l >= 0:
                left = arr[l]
            if r < len(arr):
                right = arr[r]
            
            if abs(x - right) < abs(x - left):
                res.append(right)
                r += 1
            else:
                res.insert(0, left)
                l -= 1
                
        
        return res
        