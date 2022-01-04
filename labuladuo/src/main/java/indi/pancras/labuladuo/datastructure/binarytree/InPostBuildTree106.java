package indi.pancras.labuladuo.datastructure.binarytree;

import indi.pancras.labuladuo.TreeNode;

public class InPostBuildTree106 {
    class Solution {
        public TreeNode buildTree(int[] inorder, int[] postorder) {
            return buildTreeHelper(inorder, 0, inorder.length - 1, postorder, 0, postorder.length - 1);
        }

        private TreeNode buildTreeHelper(int[] inorder, int start1, int end1, int[] postorder, int start2, int end2) {
            if (start1 > end1) {
                return null;
            }
            int rootValue = postorder[end2];
            int rootIndex = findNum(inorder, start1, end1, rootValue);
            int leftChildCnt = rootIndex - start1;
            TreeNode root = new TreeNode(rootValue);
            root.left = buildTreeHelper(inorder, start1, rootIndex - 1, postorder, start2, start2 + leftChildCnt - 1);
            root.right = buildTreeHelper(inorder, rootIndex + 1, end1, postorder, start2 + leftChildCnt, end2 - 1);
            return root;
        }

        private int findNum(int[] nums, int start, int end, int target) {
            for (int i = start; i <= end; i++) {
                if (nums[i] == target) {
                    return i;
                }
            }
            return -1;
        }
    }
}
