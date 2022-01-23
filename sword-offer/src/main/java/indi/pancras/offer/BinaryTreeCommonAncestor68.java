package indi.pancras.offer;

import indi.pancras.TreeNode;

public class BinaryTreeCommonAncestor68 {
    class Solution {
        public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
            return dfs(root, p, q);
        }

        private TreeNode dfs(TreeNode root, TreeNode p, TreeNode q) {
            if (root == null) {
                return null;
            }

            if (root == p || root == q) {
                return root;
            }
            TreeNode left = dfs(root.left, p, q);
            TreeNode right = dfs(root.right, p, q);
            if (left == null && right == null) {
                return null;
            } else if (left != null && right != null) {
                return root;
            } else if (left == null && right != null) {
                return right;
            } else {
                return left;
            }

        }
    }
}
