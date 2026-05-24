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
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        if(root == null) return res;
        
        // Queue更加高效（移除操作为O(1)）
        // ArrayList.remove(0) 每次都会把后面的元素整体往前挪，单次是 O(n)，所以整体可能退化到 O(n²)。
        Queue<TreeNode> cur = new LinkedList<>();
        cur.offer(root);
        
        while(!cur.isEmpty()){
            List<Integer> layer = new ArrayList<>();
            int lay_num = cur.size();

            for(int i = 0; i < lay_num; i++){
                TreeNode cur_node = cur.poll();
                
                layer.add(cur_node.val);
                if(cur_node.left != null) cur.offer(cur_node.left);
                if(cur_node.right != null) cur.offer(cur_node.right);
            }
            res.add(layer);
        }

        return res;
    }
}
