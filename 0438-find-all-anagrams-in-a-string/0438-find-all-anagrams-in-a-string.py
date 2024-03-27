class Solution:
    def findAnagrams(self, s: str, p: str) -> List[int]:
        letters = defaultdict(int)
        for c in p:
            letters[c] += 1
        empty_count = len(letters)
        res = []
        for i, c in enumerate(s):
            eject_index = i - len(p)
            if eject_index >= 0 and s[eject_index] in letters:
                letters[s[eject_index]] += 1
                if letters[s[eject_index]] == 1:
                    empty_count += 1
            if c in letters:
                letters[c] -= 1
                if letters[c] == 0:
                    empty_count -= 1
            
            if empty_count == 0:
                res.append(eject_index+1)
            
        
        return res
        