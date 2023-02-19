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
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        if (root == null) {
            return new ArrayList<>();
        }
        List<List<Integer>> res = new ArrayList<>();
        List<TreeNode> list = new ArrayList<>();
        list.add(root);
        List<Integer> current = new ArrayList<>();
        while (!list.isEmpty()) {
            List<TreeNode> next = new ArrayList<>();
            for (TreeNode node: list) {
                current.add(node.val);
                if (node.left!=null) {
                    next.add(node.left);
                }
                if (node.right!=null) {
                    next.add(node.right);
                }
            }
            list = next;
            res.add(current);
            current = new ArrayList<>();
        }
        for (int i=0; i<res.size(); i++) {
            if (i%2==1) {
                Collections.reverse(res.get(i));
            }
        }
        return res;
    }
}