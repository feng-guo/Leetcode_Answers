class Solution:
    def simplifyPath(self, path: str) -> str:
        stack = []
        to_stack = path.split("/")
        for folder in to_stack:
            if not folder or folder == ".":
                continue #do nothing
            if folder == "..":
                if stack:
                    stack.pop()
            else:
                stack.append(folder)
        
        return "/" + "/".join(stack)