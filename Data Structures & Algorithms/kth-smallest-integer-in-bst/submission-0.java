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
    List<Integer> arr;
    int k;
    public int kthSmallest(TreeNode root, int k) {
        arr = new ArrayList<>();
        this.k = k;
        traverse(root);
        return arr.get(k-1);
    }
    public void traverse(TreeNode root){
        if(root == null) return;
        traverse(root.left);
        if(arr.size() < k) arr.add(root.val);
        else return;
        traverse(root.right);

    }

}
