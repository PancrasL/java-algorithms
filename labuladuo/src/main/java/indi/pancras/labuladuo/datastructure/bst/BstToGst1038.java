package indi.pancras.labuladuo.datastructure.bst;

import indi.pancras.labuladuo.TreeNode;

public class BstToGst1038 {
    class Solution {
        private int sum = 0;

        public TreeNode bstToGst(TreeNode root) {
            traverse(root);
            return root;
        }

        private void traverse(TreeNode root) {
            if (root == null) {
                return;
            }
            traverse(root.right);
            sum += root.val;
            root.val = sum;
            traverse(root.left);
        }
    }
}
