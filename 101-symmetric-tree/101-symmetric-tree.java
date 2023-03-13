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
    List<Integer> left;
    List<Integer> right;
    public boolean isSymmetric(TreeNode root) {
        if (root.left == null && root.right == null) {
            return true;
        }
        left = new ArrayList<>();
        right = new ArrayList<>();
        getLeft(root.left);
        getRight(root.right);
        if (left.size() != right.size()) {
            return false;
        }
        for (int i=0; i<left.size(); i++) {
            if (left.get(i) != right.get(i)) {
                return false;
            }
        }
        return true;
    }
    
    public void getLeft(TreeNode root) {
        if (root == null) {
            left.add(-101);
            return;
        }
        left.add(root.val);
        getLeft(root.left);
        getLeft(root.right);
    }
    public void getRight(TreeNode root) {
        if (root == null) {
            right.add(-101);
            return;
        }
        right.add(root.val);
        getRight(root.right);
        getRight(root.left);
    }
}