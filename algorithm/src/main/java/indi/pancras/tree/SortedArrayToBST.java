package indi.pancras.tree;

/**
 * @author pancras
 * @tip 一段有序数组，nums[mid]为root.val，nums[left:mid-1]生成左子树，nums[mid+1:right]生成右子树
 * @create 2021/4/8 10:37
 * @see <a href="https://leetcode-cn.com/leetbook/read/top-interview-questions-easy/xninbt/">将有序数组转换为二叉搜索树</a>
 */
public class SortedArrayToBST {

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
        public TreeNode sortedArrayToBST(int[] nums) {
            return helper(nums, 0, nums.length - 1);
        }

        private TreeNode helper(int[] nums, int left, int right) {
            if (left > right)
                return null;
            if (left == right)
                return new TreeNode(nums[left], null, null);

            TreeNode root = new TreeNode();
            int mid = (left + right) / 2;
            root.val = nums[mid];
            root.left = helper(nums, left, mid - 1);
            root.right = helper(nums, mid + 1, right);
            return root;
        }
    }
}
