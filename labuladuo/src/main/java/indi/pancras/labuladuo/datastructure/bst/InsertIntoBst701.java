package indi.pancras.labuladuo.datastructure.bst;

import indi.pancras.labuladuo.TreeNode;

public class InsertIntoBst701 {
    class Solution {
        public TreeNode insertIntoBST(TreeNode root, int val) {
            if (root == null) {
                return new TreeNode(val);
            }

            TreeNode cur = root;
            TreeNode parent = null;
            while (cur != null) {
                parent = cur;
                if (val < cur.val) {
                    cur = cur.left;
                } else if (val > cur.val) {
                    cur = cur.right;
                } else {
                    throw new IllegalArgumentException();
                }
            }
            if (val < parent.val) {
                parent.left = new TreeNode(val);
            } else {
                parent.right = new TreeNode(val);
            }
            return root;
        }
    }
}
