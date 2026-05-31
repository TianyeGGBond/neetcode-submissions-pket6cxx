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

public class Codec {

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        StringBuilder sb = new StringBuilder();
        dfsSer(root, sb);
        return sb.toString();
    }
    public void dfsSer(TreeNode root, StringBuilder sb){
        if(root == null){
            sb.append("N,");
            return;
        }
        sb.append(root.val).append(",");
        dfsSer(root.left, sb);
        dfsSer(root.right, sb);
        return;
    }


    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        String[] arr = data.split(",");
        Queue<String> ls = new LinkedList<>(Arrays.asList(arr));
        return dfsDe(ls);
    }
    public TreeNode dfsDe(Queue<String> ls){
        if(ls.isEmpty()) return null;
        String curVal = ls.poll();
        if(curVal.equals("N")) return null;

        TreeNode cur = new TreeNode(Integer.parseInt(curVal));
        cur.left = dfsDe(ls);
        cur.right = dfsDe(ls);
        return cur;
    }
}
