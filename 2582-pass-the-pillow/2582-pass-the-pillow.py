class Solution:
    def passThePillow(self, n: int, time: int) -> int:
        
        
        direction = int(floor(time/(n-1)))%2
        #if even then going forward
        #if odd then going backward
        
        if direction == 0:
            return time%(n-1) + 1
        else:
            return n - time%(n-1)