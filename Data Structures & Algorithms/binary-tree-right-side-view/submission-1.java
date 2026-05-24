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
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> right_view = new ArrayList<>();
        if(root == null) return right_view;
        
        Queue<TreeNode> layer = new LinkedList<>();
        layer.offer(root);

        while(!layer.isEmpty()){
            int size = layer.size();
            
            for(int i = 0 ; i < size; i++){
                TreeNode cur_node = layer.poll();
                if(i == 0) right_view.add(cur_node.val);
                if(cur_node.right != null) layer.offer(cur_node.right);
                if(cur_node.left != null) layer.offer(cur_node.left);
            }
        }
        return right_view;
    }
}
