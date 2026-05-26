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
    boolean isValid = true;
    public boolean isValidBST(TreeNode root) {
        BSTCheck(root, Integer.MAX_VALUE, Integer.MIN_VALUE);
        return isValid;
    }

    public void BSTCheck(TreeNode root, int maxVal, int minVal){
        if(root == null || isValid == false) return;
        
        if(root.val >= maxVal || root.val <= minVal){
            isValid = false;
            return;
        }

        BSTCheck(root.left, root.val, minVal);
        BSTCheck(root.right, maxVal, root.val);
    }
}
