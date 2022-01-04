package indi.pancras.labuladuo.datastructure.binarytree;

import indi.pancras.labuladuo.TreeNode;

public class FlattenTree114 {
    class Solution {
        public void flatten(TreeNode root) {
            if(root == null){
                return;
            }
            traverse(root);
        }

        private TreeNode traverse(TreeNode root){
            // 左子树和右子树都为空
            if(root.left == null && root.right == null){
                return root;
            }
            // 左子树为空
            if(root.left == null){
                return traverse(root.right);
            }
            // 右子树为空
            if(root.right == null){
                root.right = root.left;
                root.left = null;
                return traverse(root.right);
            }
            TreeNode leftLeaf = traverse(root.left);
            TreeNode rightLeaf = traverse(root.right);

            TreeNode temp = root.right;
            root.right = root.left;
            root.left = null;
            leftLeaf.right = temp;
            return rightLeaf;
        }
    }
}
