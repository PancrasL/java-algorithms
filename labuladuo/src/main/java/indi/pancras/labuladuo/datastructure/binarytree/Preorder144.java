package indi.pancras.labuladuo.datastructure.binarytree;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

import indi.pancras.labuladuo.TreeNode;

public class Preorder144 {
    class Solution {
        public List<Integer> preorderTraversal(TreeNode root) {
            Stack<TreeNode> stack = new Stack<>();
            stack.push(root);
            List<Integer> result = new ArrayList<>();
            while (!stack.isEmpty()) {
                TreeNode pop = stack.pop();
                if (pop == null) {
                    continue;
                }
                result.add(pop.val);
                stack.push(pop.right);
                stack.push(pop.left);
            }
            return result;
        }
    }
}
