package indi.pancras.labuladuo.datastructure.bst;

import indi.pancras.labuladuo.TreeNode;

public class ValidBst98 {
    class Solution {
        private int lastVal;
        private boolean first = true;

        public boolean isValidBST(TreeNode root) {
            if (root == null) {
                return true;
            }
            boolean flag = isValidBST(root.left);
            if (!flag) {
                return false;
            }

            if (first) {
                first = !first;
            } else if (lastVal >= root.val) {
                return false;
            }
            lastVal = root.val;

            flag = isValidBST(root.right);
            return flag;
        }
    }
}
