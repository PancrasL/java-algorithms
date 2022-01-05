package indi.pancras.labuladuo.datastructure.bst;

import indi.pancras.labuladuo.TreeNode;

public class Codec297 {

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        StringBuilder sb = new StringBuilder();
        preorderSerialize(root, sb);
        return sb.toString();
    }

    private void preorderSerialize(TreeNode root, StringBuilder sb) {
        if (root == null) {
            sb.append("#,");
            return;
        }
        sb.append(root.val).append(",");
        preorderSerialize(root.left, sb);
        preorderSerialize(root.right, sb);
    }

    private int index;

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        String[] splits = data.split(",");
        index = 0;
        return preorderDeserialize(splits);
    }

    private TreeNode preorderDeserialize(String[] splits) {
        if ("#".equals(splits[index])) {
            index++;
            return null;
        }
        int val = Integer.parseInt(splits[index++]);
        TreeNode root = new TreeNode(val);
        root.left = preorderDeserialize(splits);
        root.right = preorderDeserialize(splits);
        return root;
    }

    public static void main(String[] args) {
        Codec297 s = new Codec297();
        TreeNode root = new TreeNode(1);
        System.out.println(s.serialize(root));
        String str = s.serialize(s.deserialize(s.serialize(root)));
        System.out.println(str);
    }
}
