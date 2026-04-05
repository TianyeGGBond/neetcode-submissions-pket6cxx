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
    StringBuilder sb;
    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        sb = new StringBuilder();
        if(root == null) return "x";

        dfs(root);
        return sb.toString();
    }
    private void dfs(TreeNode root){
        if(root == null){
            sb.append("x");
            sb.append(",");
            return;
        }
        sb.append(String.valueOf(root.val));
        sb.append(",");
        dfs(root.left);
        dfs(root.right);
        return;
    }

    int k;
    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        k = -1;
        if(data.isEmpty()) return null;
        String[] s = data.split(",");
        TreeNode root = dfs2(s);
        return root;
    }
    private TreeNode dfs2(String[] s){
        k++;
        if(k >= s.length) return null;

        if(s[k].equals("x")) return null;

        int cur_val = Integer.parseInt(s[k]);
        TreeNode cur = new TreeNode(cur_val);

        cur.left = dfs2(s);
        cur.right = dfs2(s);
        return cur;
    }
}
