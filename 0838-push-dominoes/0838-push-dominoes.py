class Solution:
    def pushDominoes(self, dominoes: str) -> str:
        left = []
        right = []
        l = -1
        r = -1
        for i, d in enumerate(dominoes):
            if d == "R":
                r = i
            elif d == "L":
                r = -1
                
            if dominoes[len(dominoes)-1-i] == "L":
                l = len(dominoes)-1-i
            elif dominoes[len(dominoes)-1-i] == "R":
                l = -1
            left.append(l)
            right.append(r)
        
        left = left[::-1]
        
        res = ""
        for i, d in enumerate(dominoes):
            left_most = left[i]
            right_most = right[i]
            if left_most != -1 and right_most == -1:
                res += "L"
            elif left_most == -1 and right_most != -1:
                res += "R"
            elif left_most == -1 and right_most == -1:
                res += "."
            else:
                left_d = abs(i - left_most)
                right_d = abs(i - right_most)
                if left_d < right_d:
                    res += "L"
                elif left_d > right_d:
                    res += "R"
                else:
                    res += "."
        return res