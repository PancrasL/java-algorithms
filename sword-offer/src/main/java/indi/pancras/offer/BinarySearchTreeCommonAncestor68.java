package indi.pancras.offer;

import indi.pancras.TreeNode;

public class BinarySearchTreeCommonAncestor68 {
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
            TreeNode left = null, right = null;
            if (p.val < root.val || q.val < root.val) {
                left = dfs(root.left, p, q);
            }
            if (p.val > root.val || q.val > root.val) {
                right = dfs(root.right, p, q);
            }
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
