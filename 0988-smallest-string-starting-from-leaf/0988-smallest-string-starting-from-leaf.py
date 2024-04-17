# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def smallestFromLeaf(self, root: Optional[TreeNode]) -> str:
        
        def dfs(root, s):
            c = chr(ord('a')+root.val)
            s = c + s
            if not root.left and not root.right:
                return c
            if not root.left:
                return dfs(root.right, s) + c
            if not root.right:
                return dfs(root.left, s) + c
            left_s = dfs(root.left, s)
            right_s = dfs(root.right, s)
            if left_s+s <= right_s + s:
                return left_s+c
            else:
                return right_s+c
        
        return dfs(root, "")
        