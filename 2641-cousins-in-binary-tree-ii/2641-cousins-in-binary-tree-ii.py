from collections import defaultdict

# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def replaceValueInTree(self, root: Optional[TreeNode]) -> Optional[TreeNode]:
        level_sum_map = defaultdict(int)
        parent = {}
        children_sum_map = {}
        
        def sum_level(level, node):
            level_sum_map[level] += node.val
            children_sum = 0
            
            if node.left:
                children_sum += node.left.val
                parent[node.left] = node
                sum_level(level+1, node.left)
                
            if node.right:
                children_sum += node.right.val
                parent[node.right] = node
                sum_level(level+1, node.right)
                
            children_sum_map[node] = children_sum
        
        def replace_val(level, node):
            if not node:
                return
            
            children_sum = 0
            if node in parent:
                children_sum = children_sum_map[parent[node]]
            else:
                children_sum = node.val

            node.val = level_sum_map[level] - (children_sum)
            
            replace_val(level+1, node.left)
            replace_val(level+1, node.right)
            
        sum_level(0, root)
        replace_val(0, root)
        
        return root
        