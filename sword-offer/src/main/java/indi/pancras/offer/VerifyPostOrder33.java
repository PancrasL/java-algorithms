package indi.pancras.offer;

public class VerifyPostOrder33 {
    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.verifyPostorder(new int[]{6, 5, 4, 3, 2, 1}));
    }

    static class Solution {
        public boolean verifyPostorder(int[] postorder) {
            if (postorder.length == 0) {
                return true;
            }
            return valid(postorder, 0, postorder.length - 1);
        }

        private boolean valid(int[] postorder, int start, int end) {
            if (start >= end) {
                return true;
            }
            int root = postorder[end];
            // 右子树的下标
            int index = findFirstGreaterThan(root, postorder, start, end);
            if (index == -1) {// 不存在右子树
                // 需要保证所有左子树的节点小于根
                return valid(postorder, start, end - 1);
            } else {
                // 右子树节点都要大于根才行
                for (int i = index; i <= end - 1; i++) {
                    if (postorder[i] < root) {
                        return false;
                    }
                }
                return valid(postorder, start, index - 1) && valid(postorder, index, end - 1);
            }
        }

        private int findFirstGreaterThan(int target, int[] nums, int start, int end) {
            for (int i = start; i <= end; i++) {
                if (nums[i] > target) {
                    return i;
                }
            }
            return -1;
        }
    }
}
