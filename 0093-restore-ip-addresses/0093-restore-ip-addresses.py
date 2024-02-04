class Solution:
    def restoreIpAddresses(self, s: str) -> List[str]:
        if (len(s)>12 or len(s)<4):
            return []
        res = []
        for i in range(27):
            number = i
            index = [0, 0, 0]
            index2 = [0, 0, 0]
            index[2] = (number//9) + 1 
            number = number%9
            index[1] = (number//3) + 1
            number = number%3
            index[0] = number + 1
            index2[0] = index[0]
            index2[1] = index2[0] + index[1]
            index2[2] = index2[1] + index[2]
            if index2[2] >= len(s):
                continue
            numbers = [0, 0, 0, 0]
            numbers[0] = s[:index2[0]]
            numbers[1] = s[index2[0]:index2[1]]
            numbers[2] = s[index2[1]:index2[2]]
            numbers[3] = s[index2[2]:]
            print(numbers)
            valid = True
            for n in numbers:
                if (n != "0" and n[0] == "0") or not(255 >= int(n) >= 0):
                    valid=False
                    break
            if valid:
                res.append(".".join(numbers))
        return res
                
            