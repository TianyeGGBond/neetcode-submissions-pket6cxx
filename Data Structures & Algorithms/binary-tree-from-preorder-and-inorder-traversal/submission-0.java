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
    int pre_i = 0;
    Map<Integer, Integer> map = new HashMap<>();

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        for(int i = 0; i< inorder.length; i++){
            map.put(inorder[i], i);
        }
        return dfs(preorder, 0, inorder.length-1);

    }
    private TreeNode dfs(int[] preorder, int l, int r){
        if(l > r) return null;
        int val = preorder[pre_i++];
        TreeNode root = new TreeNode(val);
        int idx = map.get(val);
        root.left = dfs(preorder,l,idx-1);
        root.right = dfs(preorder,idx+1,r);
        return root;

    }
}
