package indi.pancras.labuladuo.datastructure.bst;

import indi.pancras.labuladuo.TreeNode;

public class DeleteNode450 {
    class Solution {
        public TreeNode deleteNode(TreeNode root, int key) {
            TreeNode cur = root;
            TreeNode curParent = null;
            while (cur != null) {
                if (key == cur.val) {
                    break;
                } else if (key < cur.val) {
                    curParent = cur;
                    cur = cur.left;
                } else {
                    curParent = cur;
                    cur = cur.right;
                }
            }
            if (cur == null) {// key节点不存在
                return root;
            }
            if (curParent == null) {// 删除根节点
                return rotate(root);
            } else {
                if (cur.val < curParent.val) {
                    curParent.left = rotate(cur);
                } else {
                    curParent.right = rotate(cur);
                }
            }
            return root;
        }

        // 左旋
        private TreeNode rotate(TreeNode root) {
            TreeNode leftChild = root.left;
            TreeNode rightChild = root.right;
            if (rightChild == null) {
                return leftChild;
            }
            // 找到右子树中值最小的节点（即右子树的最左节点）
            TreeNode minRightNode = root.right;
            while (minRightNode.left != null) {
                minRightNode = minRightNode.left;
            }
            // 将左子树挂载最小节点上
            minRightNode.left = leftChild;
            return rightChild;
        }
    }
}
