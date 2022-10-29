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
    List<List<Integer>> list;
    
    public List<List<Integer>> levelOrder(TreeNode root) {
        list = new ArrayList<>();
        
        levelOrder(root, 0);

        return list;
    }
    
    public void levelOrder(TreeNode root, int level) {
        if (root != null) {
            List<Integer> subList = null;
            if (list.size()-1 < level) {
                subList = new ArrayList<>();
                list.add(subList);
            } else {
                subList = list.get(level);
            }

            subList.add(root.val);

            levelOrder(root.left, level+1);
            levelOrder(root.right, level+1);
        }
    }
}