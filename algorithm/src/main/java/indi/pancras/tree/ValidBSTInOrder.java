package indi.pancras.tree;

/**
 * @author pancras
 * @tip BST的中序遍历结果时升序的
 * @create 2021/4/7 17:17
 * @see <a href="https://leetcode-cn.com/leetbook/read/top-interview-questions-easy/xn08xg/">验证二叉搜索树</a>
 */
public class ValidBSTInOrder {

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
        long pre = Long.MIN_VALUE;

        public boolean isValidBST(TreeNode root) {
            if (root == null)
                return true;
            if (!isValidBST(root.left))
                return false;
            if (root.val <= pre)
                return false;
            pre = root.val;
            return isValidBST(root.right);
        }
    }
}
