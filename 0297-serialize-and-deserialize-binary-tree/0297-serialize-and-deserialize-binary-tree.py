# Definition for a binary tree node.
# class TreeNode(object):
#     def __init__(self, x):
#         self.val = x
#         self.left = None
#         self.right = None

class Codec:

    def serialize(self, root):
        """Encodes a tree to a single string.
        
        :type root: TreeNode
        :rtype: str
        """
        if root is None:
            return ""
        array = [root]
        res = ""
        while len(array) > 0:
            current = array.pop(0)
            if current == None:
                res += ",null"
            else:
                res += "," + str(current.val)
                array.append(current.left)
                array.append(current.right)
        print(res[1:])
        return res[1:]
            

    def deserialize(self, data):
        """Decodes your encoded data to tree.
        
        :type data: str
        :rtype: TreeNode
        """
        if data == "":
            return None
        array = data.split(",")
        root = None
        parents = []
        while len(array) > 0:
            current = array.pop(0)
            if (root == None):
                root = TreeNode(current)
                parents.append(root)
            else:
                n = array.pop(0)
                parent = parents.pop(0)
                left = TreeNode(current)
                right = TreeNode(n)
                if current is not None:
                    parents.append(left)
                if n is not None:
                    parents.append(right)
                parent.left = left
                parent.right = right
                    
            
        return root
        

# Your Codec object will be instantiated and called as such:
# ser = Codec()
# deser = Codec()
# ans = deser.deserialize(ser.serialize(root))