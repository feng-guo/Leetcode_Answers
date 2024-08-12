class Solution:
    def findContentChildren(self, g: List[int], s: List[int]) -> int:
        g.sort()
        s.sort()
        
        cookie = 0
        h = 0
        
        for i, child in enumerate(g):
            while cookie < len(s):
                if s[cookie] >= child:
                    cookie += 1
                    h += 1
                    break
                cookie += 1
                
        
        
        return h