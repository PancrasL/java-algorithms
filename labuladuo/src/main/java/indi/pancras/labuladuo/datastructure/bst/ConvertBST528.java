package indi.pancras.labuladuo.datastructure.bst;

import indi.pancras.labuladuo.TreeNode;

public class ConvertBST528 {
    class Solution {
        private int sum = 0;

        public TreeNode convertBST(TreeNode root) {
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
