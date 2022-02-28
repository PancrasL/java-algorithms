package indi.pancras.offer;

import java.util.LinkedList;
import java.util.Objects;
import java.util.Queue;

import indi.pancras.TreeNode;

public class SymmetricTree28 {
    // 层序遍历
    class Solution {
        public boolean isSymmetric(TreeNode root) {
            Queue<TreeNode> queue = new LinkedList<>();
            queue.add(root);
            while (!queue.isEmpty()) {
                int size = queue.size();
                Integer[] nums = new Integer[size];
                for (int i = 0; i < size; i++) {
                    TreeNode node = queue.poll();
                    if (node == null) {
                        nums[i] = null;
                    } else {
                        nums[i] = node.val;
                        queue.add(node.left);
                        queue.add(node.right);
                    }
                }
                if (!isPalindrome(nums)) {
                    return false;
                }
            }
            return true;
        }

        private boolean isPalindrome(Integer[] nums) {
            int left = 0, right = nums.length - 1;
            while (left < right) {
                if (!Objects.equals(nums[left++], nums[right--])) {
                    return false;
                }
            }
            return true;
        }
    }

    // 左右子树遍历
    class Solution1 {
        public boolean isSymmetric(TreeNode root) {
            return symmectricHelper(root, root);
        }

        private boolean symmectricHelper(TreeNode left, TreeNode right) {
            if (left == null && right == null) {
                return true;
            } else if (left != null && right != null) {
                if (left.val != right.val) {
                    return false;
                }
                return symmectricHelper(left.left, right.right) && symmectricHelper(left.right, right.left);
            } else {
                return false;
            }
        }
    }
}
