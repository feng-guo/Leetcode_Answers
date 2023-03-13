/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    List<TreeNode> commonRoot;
    public boolean isSubtree(TreeNode root, TreeNode subRoot) {
        commonRoot = new ArrayList<>();
        findCommonRoots(root, subRoot);
        for (TreeNode node: commonRoot) {
            if (checkSubtree(node, subRoot)) {
                return true;
            }
        }
        return false;
    }
    
    public void findCommonRoots(TreeNode root, TreeNode subRoot) {
        if (root == null) {
            return;
        }
        if (root.val == subRoot.val) {
            commonRoot.add(root);
        }
        findCommonRoots(root.left, subRoot);
        findCommonRoots(root.right, subRoot);
    }
    
    public boolean checkSubtree(TreeNode root, TreeNode subRoot) {
        if (root == null && subRoot == null) {
            return true;
        } else if (root != null && subRoot != null && root.val == subRoot.val) {
            return checkSubtree(root.left, subRoot.left) && checkSubtree(root.right, subRoot.right);
        } else {
            return false;
        }
    }
}