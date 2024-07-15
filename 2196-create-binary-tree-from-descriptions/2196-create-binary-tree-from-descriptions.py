# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def createBinaryTree(self, descriptions: List[List[int]]) -> Optional[TreeNode]:
        number_to_node = {}
        parentless_nodes = set()
        
        for desc in descriptions:
            p, c, isLeft = desc
            
            parent = None
            child = None
            if p in number_to_node:
                parent = number_to_node[p]
            else:
                parent = TreeNode(p, None, None)
                number_to_node[p] = parent
                parentless_nodes.add(parent)
            if c in number_to_node:
                child = number_to_node[c]
            else:
                child = TreeNode(c, None, None)
                number_to_node[c] = child
            parentless_nodes.discard(child)
            if isLeft:
                parent.left = child
            else:
                parent.right = child

        
        for node in parentless_nodes:
            return node
        