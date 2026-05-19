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
    int res = Integer.MIN_VALUE;
    public int diameterOfBinaryTree(TreeNode root) {
        if(root == null) return 0;
        res = Math.max(maxDir(root.left) + maxDir(root.right), res);
        return res;
    }
    private int maxDir(TreeNode root){
        if(root == null) return 0;
        int left = maxDir(root.left);
        int right = maxDir(root.right);
        res = Math.max(left + right, res);
        return Math.max(left, right) + 1;
    }
}
