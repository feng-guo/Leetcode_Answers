class Solution:
    def removeKdigits(self, num: str, k: int) -> str:
        sys.set_int_max_str_digits(100000)
        stack = []
        for n in num:
            while stack and k and stack[-1] > n:
                stack.pop()
                k -= 1
            stack.append(n)
        stack = stack[:len(stack)-k]
        return str(int("".join(stack))) if stack else "0"
                
        