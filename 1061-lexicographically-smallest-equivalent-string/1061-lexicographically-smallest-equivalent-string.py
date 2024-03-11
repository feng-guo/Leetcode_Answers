class UnionFind:
    def __init__(self, chars, size):
        self.par = chars
        self.size = size
        self.count = len(chars)
    
    def find(self, x):
        if x not in self.par:
            return x
        if self.par[x] != x:
            self.par[x] = self.find(self.par[x])
        return self.par[x]
    
    def union(self, x, y):
        px, py = self.find(x), self.find(y)
        if px == py:
            return
        if self.size[px] < self.size[py]:
            self.par[px] = py
            self.size[py] += self.size[px]
        else:
            self.par[py] = px
            self.size[px] += self.size[py]
        self.count -= 1

class Solution:
    def smallestEquivalentString(self, s1: str, s2: str, baseStr: str) -> str:
        
        chars = {}
        for c in s1:
            chars[c] = c
        for c in s2:
            chars[c] = c
        size = {}
        for c in chars:
            size[c] = 1
        uf = UnionFind(chars, size)
        
        for i in range(len(s1)):
            c1 = s1[i]
            c2 = s2[i]
            uf.union(c1, c2)
        
        lowest_char = {}
        for c in chars:
            rep = uf.find(c)
            if rep not in lowest_char or lowest_char[rep] > c:
                lowest_char[rep] = c
        res = ""
        for c in baseStr:
            rep = uf.find(c)
            if rep in lowest_char:
                res += lowest_char[uf.find(c)]
            else:
                res += c
        return res
                
            
        
        