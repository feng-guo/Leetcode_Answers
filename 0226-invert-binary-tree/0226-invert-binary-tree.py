# Definition for a binary tree node.
# class TreeNode(object):
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution(object):
    def invertTree(self, root):
        """
        :type root: TreeNode
        :rtype: TreeNode
        """
        if root is None:
            return None
        queue = [root]
        while len(queue) > 0:
            current = queue.pop(0)
            tmp = current.left
            current.left = current.right
            current.right = tmp
            if current.left != None:
                queue.append(current.left)
            if current.right != None:
                queue.append(current.right) 
        return root
                
        