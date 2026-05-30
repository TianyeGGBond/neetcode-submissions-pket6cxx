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
    HashMap<Integer, Integer> inorderMap = new HashMap<>();
    int preidx = 0;
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        for(int i = 0; i < inorder.length; i++){
            inorderMap.put(inorder[i], i);
        }

        return dfs(preorder, 0, preorder.length - 1);
    }
    private TreeNode dfs(int[] preorder, int left, int right){
        if(left > right) return null;
        int curVal = preorder[preidx];
        preidx++;
        TreeNode cur = new TreeNode(curVal);
        int inIdx = inorderMap.get(curVal);

        cur.left = dfs(preorder, left, inIdx-1);
        cur.right = dfs(preorder, inIdx+1, right);
        
        return cur;
    }
}
