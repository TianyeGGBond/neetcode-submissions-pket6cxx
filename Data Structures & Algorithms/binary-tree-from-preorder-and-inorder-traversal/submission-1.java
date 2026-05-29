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
 ()
 1234567890
 * }
 */

class Solution {
    int pre_idx = 0;
    HashMap<Integer, Integer> inorder_map = new HashMap<>();

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        for(int i = 0; i < inorder.length; i++){
            inorder_map.put(inorder[i], i);
        }
        return dfs(preorder, 0, inorder.length - 1); 
    }

    public TreeNode dfs(int[] preorder, int left, int right){
        if(left > right) return null;
        int cur_val = preorder[pre_idx];
        pre_idx++;

        TreeNode cur = new TreeNode(cur_val);
        int in_idx = inorder_map.get(cur_val);

        cur.left = dfs(preorder, left, in_idx - 1); 
        cur.right = dfs(preorder, in_idx + 1, right);

        return cur;
    }

}
