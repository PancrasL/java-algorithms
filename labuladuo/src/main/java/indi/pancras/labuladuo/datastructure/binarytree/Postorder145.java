package indi.pancras.labuladuo.datastructure.binarytree;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

import indi.pancras.labuladuo.TreeNode;

public class Postorder145 {
    class Solution {
        public List<Integer> postorderTraversal(TreeNode root) {
            Stack<TreeNode> stack = new Stack<>();
            List<Integer> ans = new ArrayList<>();
            pushLeftChild(root, stack);
            TreeNode lastNode = null;
            while (!stack.isEmpty()) {
                TreeNode pop = stack.pop();
                if (pop.right == null || pop.right == lastNode) {
                    lastNode = pop;
                    ans.add(pop.val);
                } else {
                    stack.push(pop);
                    pushLeftChild(pop.right, stack);
                }
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
