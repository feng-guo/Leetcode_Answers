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
    public List<Integer> rightSideView(TreeNode root) {
        List<TreeNode> queue = new ArrayList<>();
        List<Integer> list = new ArrayList<>();
        List<TreeNode> next;
        
        if (root == null) {
            return list;
        }
        queue.add(root);
        while (!queue.isEmpty()) {
            next = new ArrayList<>();
            for (TreeNode node: queue) {
                if (node.left!= null) {
                    next.add(node.left);
                }
                if (node.right!= null) {
                    next.add(node.right);
                }
            }
            list.add(queue.get(queue.size()-1).val);
            queue = next;
        }
        return list;
    }
}