package indi.pancras.tree;

/**
 * @author pancras
 * @tip 递归验证
 * @create 2021/4/7 17:17
 * @see <a href="https://leetcode-cn.com/leetbook/read/top-interview-questions-easy/xn08xg/">验证二叉搜索树</a>
 */
public class ValidBSTRecursion {

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    class Solution {
        public boolean isValidBST(TreeNode root) {
            return isValidBSTHelper(root, Long.MIN_VALUE, Long.MAX_VALUE);
        }

        private boolean isValidBSTHelper(TreeNode root, long minValue, long maxValue) {
            if (root == null)
                return true;
            if (root.val >= maxValue || root.val <= minValue) {
                return false;
            }
            return isValidBSTHelper(root.left, minValue, root.val) & isValidBSTHelper(root.right, root.val, maxValue);
        }
    }
}
