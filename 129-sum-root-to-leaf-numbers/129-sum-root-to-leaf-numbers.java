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
    int sum = 0;
    public int sumNumbers(TreeNode root) {
        sum(root, 0);
        return sum;
    }
    
    public void sum(TreeNode root, int parent) {
        if (root == null) {
            return;
        } else if (root.left == null && root.right == null) {
            sum += root.val + parent*10;
        } else {
            sum(root.left, root.val + parent*10);
            sum(root.right, root.val + parent*10);
        }
    }
}