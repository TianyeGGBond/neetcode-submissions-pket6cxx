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
    public boolean isSubtree(TreeNode root, TreeNode subRoot) {
        if(root == null && subRoot == null) return true;
        else if(subRoot == null) return true;
        else if(root == null) return false;

        boolean res = false;
        if(root.val == subRoot.val) res = isSame(root, subRoot);

        return res  || isSubtree(root.right,subRoot) || isSubtree(root.left,subRoot) ;
    }
    private boolean isSame(TreeNode p, TreeNode q){
        if(p == null && q == null) return true;
        else if(p == null || q == null) return false;

        if(p.val == q.val) {
            boolean left = isSame(p.left, q.left);
            boolean right = isSame(p.right, q.right);
            return left && right;
        }

        return false;
    }
}
