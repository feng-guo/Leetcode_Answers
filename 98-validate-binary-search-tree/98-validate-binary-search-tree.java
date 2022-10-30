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
    public boolean isValidBST(TreeNode root) {
        return isValidBST(root, Long.MAX_VALUE, Long.MIN_VALUE, false, false);
    }
    
    public boolean isValidBST(TreeNode root, long max, long min, boolean set_max, boolean set_min) {
        if (root == null) {
            return true;
        }
        if ( (root.val <= min && set_max) || (root.val >= max && set_min)) {
            return false;
        }
        if (root.left != null && root.left.val >= root.val) {
            return false;
        } 
        if (root.right != null && root.right.val <= root.val) {
            return false;
        }
        
        return isValidBST(root.left, Math.min(max, root.val), min, true, set_min) && isValidBST(root.right, max, Math.max(min, root.val), set_max, true);
    }
}