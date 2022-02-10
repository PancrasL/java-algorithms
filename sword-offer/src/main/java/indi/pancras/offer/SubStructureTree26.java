package indi.pancras.offer;

import indi.pancras.TreeNode;

public class SubStructureTree26 {
    class Solution {
        public boolean isSubStructure(TreeNode A, TreeNode B) {
            if (B == null || A == null) {
                return false;
            }
            if (A.val == B.val) {
                if (helper(A.left, B.left) && helper(A.right, B.right)) {
                    return true;
                }
            }
            return isSubStructure(A.left, B) || isSubStructure(A.right, B);
        }

        private boolean helper(TreeNode A, TreeNode B) {
            if (B == null) {
                return true;
            } else if (A == null) {
                return false;
            }
            if (A.val == B.val) {
                return helper(A.left, B.left) && helper(A.right, B.right);
            }
            return false;
        }
    }
}
