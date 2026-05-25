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
    int goodNode = 0;
    public int goodNodes(TreeNode root) {
        if(root == null) return 0;
        maxNum(root, root.val);
        return goodNode;
    }

    public void maxNum(TreeNode root, int max){
        if(root == null) return;

        int curMax = root.val;
        if(curMax < max){
            curMax = max;
        }else{
            goodNode += 1;
        }
        
        maxNum(root.left, curMax);
        maxNum(root.right, curMax);
    }
}
