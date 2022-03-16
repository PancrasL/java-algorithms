package indi.pancras.offer;

import indi.pancras.TreeNode;

public class BinaryTreeDepth55 {
    class Solution {
        public int maxDepth(TreeNode root) {
            if (root == null) {
                return 0;
            }
            int left = maxDepth(root.left);
            int right = maxDepth(root.right);
            return Math.max(left, right) + 1;
        }
    }
}
