package indi.pancras.labuladuo.datastructure.bst;

import indi.pancras.labuladuo.TreeNode;

public class MaxSumBst1373 {
    class Solution {
        class Node {
            TreeNode root;
            boolean isBst;
            Integer minVal;
            Integer maxVal;
            Integer sum;

            public Node(TreeNode root, boolean isBst, Integer minVal, Integer maxVal, Integer sum) {
                this.root = root;
                this.isBst = isBst;
                this.minVal = minVal;
                this.maxVal = maxVal;
                this.sum = sum;
            }
        }

        private int maxSum = 0;

        public int maxSumBST(TreeNode root) {
            postTraverse(root);
            return maxSum;
        }

        private Node postTraverse(TreeNode root) {
            if (root == null) {
                return new Node(null, true, Integer.MAX_VALUE, Integer.MIN_VALUE, 0);
            }
            Node left = postTraverse(root.left);
            Node right = postTraverse(root.right);
            if (!left.isBst || !right.isBst || root.val <= left.maxVal || root.val >= right.minVal) {
                return new Node(root, false, null, null, null);
            }
            int sum = root.val + left.sum + right.sum;
            if (maxSum < sum) {
                maxSum = sum;
            }
            int minVal = root.left == null ? root.val : left.minVal;
            int maxVal = root.right == null ? root.val : right.maxVal;
            return new Node(root, true, minVal, maxVal, sum);
        }
    }
}
