package indi.pancras.labuladuo.datastructure.bst;

import indi.pancras.labuladuo.TreeNode;

public class SearchBst700 {
    class Solution {
        public TreeNode searchBST(TreeNode root, int val) {
            TreeNode node = root;
            while (node!=null){
                if(val < node.val){
                    node = node.left;
                }else if(val == node.val){
                    break;
                }else{
                    node = node.right;
                }
            }
            return node;
        }
    }
}
