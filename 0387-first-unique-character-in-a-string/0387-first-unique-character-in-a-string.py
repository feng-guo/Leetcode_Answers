from collections import OrderedDict

class Solution:
    def firstUniqChar(self, s: str) -> int:
        d = OrderedDict()
        dupes = set()
        for i in range(len(s)):
            c = s[i]
            if c in dupes:
                continue
            if c in d:
                d.pop(c)
                dupes.add(c)
            else:
                d[c] = i
        
        for k in d.keys():
            return d[k] 
        return -1