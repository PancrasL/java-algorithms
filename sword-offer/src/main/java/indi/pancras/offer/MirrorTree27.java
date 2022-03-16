package indi.pancras.offer;

import indi.pancras.TreeNode;

public class MirrorTree27 {
    class Solution {
        public TreeNode mirrorTree(TreeNode root) {
            if (root == null) {
                return root;
            }
            // 交换左右节点
            TreeNode temp = root.left;
            root.left = root.right;
            root.right = temp;
            mirrorTree(root.left);
            mirrorTree(root.right);
            return root;
        }
    }
}
