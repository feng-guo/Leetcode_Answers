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
    int max;
    Map<TreeNode, Integer> map;
    public int diameterOfBinaryTree(TreeNode root) {
        max = 0;
        map = new HashMap<>();
        findHeight(root);
        findMax(root);
        for (TreeNode key: map.keySet()) {
            System.out.println(key.val + " " + map.get(key));
        }
        return max;
    }
    
    public void findHeight(TreeNode root) {
        if (root==null) {
            return;
        } else if (root.left == null && root.right == null) {
            map.put(root, 0);
            return;
        }
        findHeight(root.left);
        findHeight(root.right);
        int leftHeight = root.left == null?0:map.get(root.left);
        int rightHeight = root.right == null?0:map.get(root.right);
        map.put(root, Math.max(leftHeight, rightHeight)+1);
    }
    
    public void findMax(TreeNode root) {
        if (root.left == null && root.right == null) {
            max = Math.max(max, 0);
        } else if (root.left == null) {
            max = Math.max(max, 1+map.get(root.right));
            findMax(root.right);
        } else if (root.right == null) {
            max = Math.max(max, 1+map.get(root.left));
            findMax(root.left);
        } else {
            max = Math.max(max, 2+map.get(root.left)+map.get(root.right));
            findMax(root.left);
            findMax(root.right);
        }
    }
}