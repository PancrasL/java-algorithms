package indi.pancras.labuladuo.datastructure.binarytree;

import indi.pancras.labuladuo.TreeNode;

public class CountNodes222 {
    class Solution {
        public int countNodes(TreeNode root) {
            if (root == null) {
                return 0;
            }
            int leftCnt = countNodes(root.left);
            int rightCnt = countNodes(root.right);
            return leftCnt + rightCnt + 1;
        }
    }

    class Solution1 {
        public int countNodes(TreeNode root) {
            if (root == null) {
                return 0;
            }
            int hl = 0, hr = 0;
            TreeNode left = root, right = root;
            while (left != null) {
                hl++;
                left = left.left;
            }
            while (right != null) {
                hr++;
                right = right.right;
            }
            if (hr == hl) {
                return (int) Math.pow(2, hr) - 1;
            } else {
                return 1 + countNodes(root.left) + countNodes(root.right);
            }
        }
    }
}
