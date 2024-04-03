class Solution:
    def minFlips(self, s: str) -> int:
        flip1 = 0
        flip2 = 0
        for i, c in enumerate(s):
            if i%2 == 0:
                ## should be a 0 here
                if c == "0":
                    ## should be a 1 the other way
                    flip2 += 1
                else:
                    ## should be a 0
                    flip1 += 1
            else:
                ## should be a 1 here
                if c == "0":
                    flip1 += 1
                else:
                    flip2 += 1
        
        res = min(flip1, flip2)
        
        for i, c in enumerate(s):
            if i%2 == 0:
                ## should be a 0 here
                if c == "0":
                    ## should be a 1 the other way
                    flip2 -= 1
                else:
                    ## should be a 0
                    flip1 -= 1
            else:
                ## should be a 1 here
                if c == "0":
                    flip1 -= 1
                else:
                    flip2 -= 1
            end = len(s) + i
            if end%2 == 0:
                ## should be a 0 here
                if c == "0":
                    ## should be a 1 the other way
                    flip2 += 1
                else:
                    ## should be a 0
                    flip1 += 1
            else:
                ## should be a 1 here
                if c == "0":
                    flip1 += 1
                else:
                    flip2 += 1
        
            res = min(res, flip1, flip2)
        
        return res
        
        
                