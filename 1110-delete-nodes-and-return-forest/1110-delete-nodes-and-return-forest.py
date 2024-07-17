# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def delNodes(self, root: Optional[TreeNode], to_delete: List[int]) -> List[TreeNode]:
        delete_set = set(to_delete)
        
        res = []
        
        if root and root.val not in delete_set:
            res.append(root)
        
        def delete_node(root, res, delete_set):
            left = root.left
            right = root.right
            #if the current has to be deleted
            if root.val in delete_set:
                #add left child to res if it isn't deleted
                if root.left and root.left.val not in delete_set:
                    res.append(root.left)
                #add right child to res if it isn't deleted
                if root.right and root.right.val not in delete_set:
                    res.append(root.right)
            else:
                #if current isn't deleted but left child is
                #dereference left child from current
                if root.left and root.left.val in delete_set:
                    root.left = None
                #if current isn't deleted but left child is
                #dereference right child from current
                if root.right and root.right.val in delete_set:
                    root.right = None
            #recursive call if left
            #recursive call if right
            if left:
                delete_node(left, res, delete_set)
            if right:
                delete_node(right, res, delete_set)
        
        if not delete_set:
            return res
        
        if root:
            delete_node(root, res, delete_set)
        
        return res
        
    
        