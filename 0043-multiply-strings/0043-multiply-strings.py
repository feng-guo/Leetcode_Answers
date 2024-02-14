class Solution:
    def multiply(self, num1: str, num2: str) -> str:
        if (num1[0] == "0" or num2[0] == "0"):
            return "0"
        
        prev = ""
        for x in range(len(num1)):
            i = len(num1) - 1 - x
            i = int(num1[i]) 
            carry = 0
            current = ""
            for p in range(x):
                current += "0"
            for y in range(len(num2)):
                j = len(num2) - 1 - y
                j = int(num2[j])
                product = i*j + carry
                current += str(product%10)
                carry = product//10
            if (carry > 0):
                current += str(carry)
                carry = 0
            n = ""
            for i in range(len(current)):
                n1 = int(current[i])
                n2 = 0
                if (i < len(prev)):
                    n2 = int(prev[i])
                s = n1+n2 + carry
                n += str(s%10)
                carry = s//10
            if (carry > 0):
                n += str(carry)
                carry = 0
            prev = n
                
                
        
        return prev[::-1]