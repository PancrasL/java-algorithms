package indi.pancras.offer;

import indi.pancras.TreeNode;

public class BSTKthLarges54 {
    class Solution {
        boolean find;
        int cnt;
        int res = -1;

        public int kthLargest(TreeNode root, int k) {
            if (root == null || k < 1) {// error
                return res;
            }
            find = false;
            cnt = k;
            res = -1;
            findKth(root);
            return res;
        }


        private void findKth(TreeNode root) {
            if (find || root == null) {
                return;
            }
            if (--cnt == 0) {
                find = true;
                res = root.val;
            }
            findKth(root.right);
            findKth(root.left);
        }
    }
}
