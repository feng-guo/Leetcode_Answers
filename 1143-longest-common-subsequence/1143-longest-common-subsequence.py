class Solution:
    def longestCommonSubsequence(self, text1: str, text2: str) -> int:
        
        self.list1 = []
        self.text1 = text1
        self.text2 = text2
        for i in range(len(text1)):
            list2 = []
            for j in range(len(text2)):
                list2.append(-1)
            self.list1.append(list2)
        for x in range(len(text1)):
            for y in range(len(text2)):
                self.fill_grid(x, y)
        
        
        return self.list1[0][0]
    
    def fill_grid(self, x, y) -> int:
        if x == len(self.text1) or y == len(self.text2):
            return 0
        if self.list1[x][y] != -1:
            return self.list1[x][y]
        
        if self.text1[x] == self.text2[y]:
            self.list1[x][y] = 1 + self.fill_grid(x+1, y+1)
        else:
            self.list1[x][y] = max(self.fill_grid(x+1, y), self.fill_grid(x, y+1))
        return self.list1[x][y]
        