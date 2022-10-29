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
    Map<TreeNode, Integer> map;
    public boolean isBalanced(TreeNode root) {
        if (root == null) {
            return true;
        }
        if (map == null) {
            map = new HashMap<>();
        }
        
        if (isBalanced(root.left) && isBalanced(root.right)) {
            if (root.right == null && root.left == null) {
                map.put(root, 1);
            } else if (root.right == null) {
                map.put(root, 1 + map.get(root.left));
            } else if (root.left == null) {
                map.put(root, 1 + map.get(root.right));
            } else {
                map.put(root, 1 + Math.max(map.get(root.right), map.get(root.left)));
            }
            
            int left = 0;
            int right = 0;
            if (root.left != null) {
                left = map.get(root.left);
            }
            if (root.right != null) {
                right = map.get(root.right);
            }
            return Math.abs(left-right) < 2;
        }
        return false;        
    }
}