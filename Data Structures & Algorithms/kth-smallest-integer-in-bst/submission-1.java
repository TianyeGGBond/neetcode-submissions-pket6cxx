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
    Stack<Integer> s = new Stack<>();
    public int kthSmallest(TreeNode root, int k) {
        dfs(root,k);
        return s.pop();
    }
    private void dfs(TreeNode root, int k){
        
        if(root == null) return;
        dfs(root.left,k);
        if(s.size() == k) return;
        s.push(root.val);
        dfs(root.right,k);
    }
}
