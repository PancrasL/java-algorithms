package indi.pancras.labuladuo.datastructure.bst;

import indi.pancras.labuladuo.TreeNode;

public class KthSmallest230 {
    class Solution {
        private int cnt;

        public int kthSmallest(TreeNode root, int k) {
            if (root == null) {
                return -1;
            }
            int val = kthSmallest(root.left, k);
            if(val !=-1){
                return val;
            }
            cnt = cnt + 1;
            if (cnt == k) {
                return root.val;
            }
            return kthSmallest(root.right, k);
        }
    }
}
