class Solution:
    def minRemoveToMakeValid(self, s: str) -> str:
        to_delete = set()
        stack = []
        for i, c in enumerate(s):
            if c == "(":
                stack.append(i)
            elif c == ")":
                if stack:
                    stack.pop()
                else:
                    to_delete.add(i)
        
        to_delete.update(stack)
        
        res = ""
        for i, c in enumerate(s):
            if i not in to_delete:
                res += c
        
        return res