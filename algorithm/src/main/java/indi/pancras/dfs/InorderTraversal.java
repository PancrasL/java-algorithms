package indi.pancras.dfs;

import java.util.LinkedList;
import java.util.List;

/**
 * @author pancras
 * @tip DFS中序遍历
 * @create 2021/3/23 15:49
 * @see <a href="https://leetcode-cn.com/leetbook/read/queue-stack/gnq5i/">二叉树的中序遍历</a>
 */
public class InorderTraversal {

    class TreeNode {
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
        public List<Integer> inorderTraversal(TreeNode root) {
            List<Integer> result = new LinkedList<>();

            inorder(root, result);

            return result;
        }

        private void inorder(TreeNode root, List<Integer> list) {
            if (root == null) {
                return;
            }
            inorder(root.left, list);
            list.add(root.val);
            inorder(root.right, list);
        }
    }
}
