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
    int max = Integer.MIN_VALUE;
    public int maxPathSum(TreeNode root) {
        if(root == null) return 0;
        dfs(root);
        return max;
    }
    private int dfs(TreeNode root){
        if (root == null) return 0;
        int left = dfs(root.left);
        int right = dfs(root.right);
        int side_max = Math.max(left, right);

        if(side_max > 0){
            int temp = Math.max(side_max, left + right + root.val);
            temp = Math.max(side_max + root.val, temp);
            temp = Math.max(root.val, temp);
            max = Math.max(temp,max);
            return Math.max(side_max + root.val, root.val);
        }else{
            //side_max <= 0
            max = Math.max(root.val, max);
            return root.val;
        }
        

        
    }
}
