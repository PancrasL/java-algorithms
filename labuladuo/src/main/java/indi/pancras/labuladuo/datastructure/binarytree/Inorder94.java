package indi.pancras.labuladuo.datastructure.binarytree;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

import indi.pancras.labuladuo.TreeNode;

public class Inorder94 {
    class Solution {
        public List<Integer> inorderTraversal(TreeNode root) {
            Stack<TreeNode> stack = new Stack<>();
            pushLeftChild(root, stack);
            List<Integer> ans = new ArrayList<>();
            while (!stack.isEmpty()) {
                TreeNode pop = stack.pop();
                if (pop.right != null) {
                    pushLeftChild(pop.right, stack);
                }
                ans.add(pop.val);
            }
            return ans;
        }

        private void pushLeftChild(TreeNode root, Stack<TreeNode> stack) {
            while (root != null) {
                stack.push(root);
                root = root.left;
            }
        }
    }
}
