class Solution:
    def uncommonFromSentences(self, s1: str, s2: str) -> List[str]:
        res = set()
        seen = set()
        
        for word in (s1 + " " + s2).split(" "):
            if word not in seen:
                seen.add(word)
                res.add(word)
            elif word in res:
                res.remove(word)
                
        
        
        
        return list(res)