class Solution:
    def isIsomorphic(self, s: str, t: str) -> bool:
        s_set = set()
        t_set = set()
        mapping = set()
        if len(s) != len(t):
            return False
        for i, t_c in enumerate(t):
            s_c = s[i]
            if (s_c, t_c) in mapping:
                continue
            if s_c not in s_set and t_c not in t_set:
                s_set.add(s_c)
                t_set.add(t_c)
                mapping.add((s_c, t_c))
            elif (s_c in s_set or t_c in t_set) and (s_c, t_c) not in mapping:
                return False
        return True