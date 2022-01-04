package indi.pancras.labuladuo.datastructure.binarytree;

import indi.pancras.labuladuo.TreeNode;

public class ReverseTree226 {
    class Solution {
        public TreeNode invertTree(TreeNode root) {
            traverse(root);
            return root;
        }

        private void traverse(TreeNode root){
            if(root == null){
                return;
            }
            traverse(root.left);
            traverse(root.right);
            TreeNode temp = root.left;
            root.left = root.right;
            root.right = temp;
        }
    }
}
