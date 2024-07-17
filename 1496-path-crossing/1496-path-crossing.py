class Solution:
    def isPathCrossing(self, path: str) -> bool:
        pos = set()
        
        x = 0
        y = 0
        
        pos.add((x,y))
        
        for p in path:
            if p == "N":
                y += 1
            elif p == "E":
                x += 1
            elif p == "S":
                y -= 1  
            elif p == "W":
                x -= 1
            
            if (x,y) not in pos:
                pos.add((x,y))
            else:
                return True
        
        return False