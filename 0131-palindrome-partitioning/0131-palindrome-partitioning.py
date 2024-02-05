class Solution:
    def partition(self, s: str) -> List[List[str]]:
        def is_palindrome(string) -> bool:
            if len(string) == 1:
                return True
            if len(string) == 2:
                return string[0] == string[1]
            cut = ceil(len(string)/2)
#             print(cut)
#             print(string[:cut])
            # print(string[len(string):-cut-1:-1])
            
            return string[:cut] == string[len(string):-cut-1:-1]
        
        res = []
        
        for i in range(0, 2**(len(s)-1)):
            partitions = [0]
            substrings = []
            number = i
            index = 0
            while number > 0:
                index += 1
                if number%2 == 1:
                    partitions.append(index)
                number//=2
                
            valid = True
            for j in range(len(partitions)-1):
                substring = s[partitions[j]:partitions[j+1]]
                if not is_palindrome(substring):
                    valid = False
                    break
                else:
                    substrings.append(substring)
            substring = s[partitions[len(partitions)-1]:]
            if not is_palindrome(substring):
                valid = False
            else:
                substrings.append(substring)
            if valid:
                res.append(substrings) 
        
        return res