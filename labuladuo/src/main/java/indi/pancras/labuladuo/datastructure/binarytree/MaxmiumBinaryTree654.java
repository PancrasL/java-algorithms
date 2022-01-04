package indi.pancras.labuladuo.datastructure.binarytree;

import indi.pancras.labuladuo.TreeNode;

public class MaxmiumBinaryTree654 {
    class Solution {
        // 记录nums中[start,end]区间内的最大数字的下标
        private int[][] matrix;

        public TreeNode constructMaximumBinaryTree(int[] nums) {
            matrix = new int[nums.length][nums.length];
            for (int i = 0; i < nums.length; i++) {
                matrix[i][i] = i;
                for (int j = i + 1; j < nums.length; j++) {
                    int index = matrix[i][j - 1];
                    if (nums[j] > nums[index]) {
                        matrix[i][j] = j;
                    } else {
                        matrix[i][j] = index;
                    }
                }
            }
            return buildTree(nums, 0, nums.length - 1);
        }

        private TreeNode buildTree(int[] nums, int start, int end) {
            if (start > end) {
                return null;
            }
            int maxNumIndex = matrix[start][end];
            TreeNode root = new TreeNode(nums[maxNumIndex]);
            root.left = buildTree(nums, start, maxNumIndex - 1);
            root.right = buildTree(nums, maxNumIndex + 1, end);
            return root;
        }
    }

    class Solution2 {
        public TreeNode constructMaximumBinaryTree(int[] nums) {
            return constructTree(nums, 0, nums.length - 1);
        }

        private TreeNode constructTree(int[] nums, int start, int end) {
            if (start > end) {
                return null;
            }
            int index = start;
            for (int i = start + 1; i <= end; i++) {
                if (nums[i] > nums[index]) {
                    index = i;
                }
            }
            TreeNode root = new TreeNode(nums[index]);
            root.left = constructTree(nums, start, index - 1);
            root.right = constructTree(nums, index + 1, end);
            return root;
        }
    }
}
