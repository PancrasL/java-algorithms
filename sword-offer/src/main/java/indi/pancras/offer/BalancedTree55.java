package indi.pancras.offer;

import indi.pancras.TreeNode;

public class BalancedTree55 {
    class Solution {
        public boolean isBalanced(TreeNode root) {
            return treeDeepth(root) != -1;
        }

        // 如果左右子树高度差大于1，返回-1，否则返回树高
        private int treeDeepth(TreeNode root) {
            if (root == null) {
                return 0;
            }
            int left = treeDeepth(root.left);
            int right = treeDeepth(root.right);
            if (root.val == 2) {
                System.out.println(left + "," + right);
            }
            if (Math.abs(right - left) > 1) {
                return -1;
            }
            return Math.max(left, right) + 1;
        }
    }
}
