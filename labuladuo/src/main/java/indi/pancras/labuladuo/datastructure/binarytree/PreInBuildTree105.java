package indi.pancras.labuladuo.datastructure.binarytree;

import indi.pancras.labuladuo.TreeNode;

public class PreInBuildTree105 {
    class Solution {
        public TreeNode buildTree(int[] preorder, int[] inorder) {
            return buildTreeHelper(preorder, 0, preorder.length-1, inorder, 0, inorder.length-1);
        }

        private TreeNode buildTreeHelper(int[] preorder, int start1, int end1, int[] inorder, int start2, int end2) {
            if (start1 > end1) {
                return null;
            }
            int rootValue = preorder[start1];
            int rootIndex = findNum(inorder, start2, end2, rootValue);
            int leftChildCnt = rootIndex - start2;
            TreeNode root = new TreeNode(rootValue);
            root.left = buildTreeHelper(preorder, start1 + 1, start1 + leftChildCnt, inorder, start2, rootIndex - 1);
            root.right = buildTreeHelper(preorder, start1 + leftChildCnt + 1, end1, inorder, rootIndex + 1, end2);
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
