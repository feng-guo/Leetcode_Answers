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
    public int countNodes(TreeNode root) {
        int levels = 0;
        TreeNode next = root;
        if (next == null) {
            return 0;
        } else if (root.left == null && root.right == null) {
            return 1;
        } else if (root.left == null || root.right == null) {
            return 2;
        }
        while(next.left != null || next.right != null) {
            levels++;
            next = next.left;
        }
        //At this point, levels should store the last full level
        
        
        int left = (int) Math.pow(2, levels);
        int right = (int) Math.pow(2, levels+1) - 1;
        
        int min = left;
        int max = right;
        
        System.out.println(search(root, 4));
        
        while(left != right) {
            int mid = (left+right)/2;
            System.out.println("mid: " +mid);
            System.out.println(search(root, mid));
            if (search(root, mid)) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }
        
        if (search(root, left)) {
            return left;
        } else {
            return left-1;
        }
    }
    
    public boolean search(TreeNode root, int mid) {
        int route = 0;
        int count = 0;
        while (mid != 1) {
            count++;
            route <<= 1;
            route += mid & 1;
            mid >>= 1;
        }
        while (count != 0) {
            count--;
            if ((route & 1) == 1) {
                if (root.right != null) {
                    root = root.right;
                } else {
                    return false;
                }
            } else {
                if (root.left != null) {
                    root = root.left;
                } else {
                    return false;
                }
            }
            route >>= 1;
        }
        
        
        return true;
    }
}