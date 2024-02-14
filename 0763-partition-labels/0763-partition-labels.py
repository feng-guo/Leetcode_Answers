from collections import OrderedDict

class Solution:
    def partitionLabels(self, s: str) -> List[int]:
        start = OrderedDict()
        end = {}
        
        for i in range(len(s)):
            c = s[i]
            if c not in start:
                start[c] = i
            end[c] = i
    
        res = []
        start_s = 0
        end_s = 0
        for c in start:
            letter_start = start[c]
            letter_end = end[c]
            if (letter_start > end_s):
                res.append(end_s-start_s+1)
                start_s = letter_start
                end_s = letter_end
            if (letter_end > end_s):
                end_s = letter_end
        res.append(end_s-start_s+1)
        
        return res
            
        
        