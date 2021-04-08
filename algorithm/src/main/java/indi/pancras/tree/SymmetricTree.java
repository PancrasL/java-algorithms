package indi.pancras.tree;

/**
 * @author pancras
 * @tip 递归判断
 * @create 2021/4/7 17:47
 * @see <a href="https://leetcode-cn.com/leetbook/read/top-interview-questions-easy/xn7ihv/">对称二叉树</a>
 */
public class SymmetricTree {

    static class TreeNode {
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
        public boolean isSymmetric(TreeNode root) {
            return root == null || isSymmetricHelper(root.left, root.right);
        }

        private boolean isSymmetricHelper(TreeNode left, TreeNode right) {
            if ((left == null && right != null) || (left != null && right == null))// 左空·右不空 || 左不空·右空
                return false;

            if (left == null) // 左右均为空
                return true;

            if (left.val != right.val)
                return false;

            return isSymmetricHelper(left.left, right.right) & isSymmetricHelper(left.right, right.left);
        }
    }
}
