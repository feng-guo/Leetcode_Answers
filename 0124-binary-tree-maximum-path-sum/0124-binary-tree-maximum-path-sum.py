# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def maxPathSum(self, root: Optional[TreeNode]) -> int:
        
        def maxPath(root):
            if not root:
                return float('-inf'), float('-inf')
            max_left_root, max_left = maxPath(root.left)
            max_right_root, max_right = maxPath(root.right)
            
            max_through_root = max(max(max_left_root, max_right_root) + root.val, root.val)
            max_root = max(max_left, max_right, max_through_root, root.val + max_left_root + max_right_root)
            return max_through_root, max_root
        
        return maxPath(root)[1]