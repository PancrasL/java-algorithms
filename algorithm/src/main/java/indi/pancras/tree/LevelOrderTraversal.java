package indi.pancras.tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @author pancras
 * @tip 队列
 * @create 2021/4/8 10:29
 * @see <a href="https://leetcode-cn.com/leetbook/read/top-interview-questions-easy/xnldjj/">二叉树的层序遍历</a>
 */
public class LevelOrderTraversal {

    static class TreeNode {
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
        public List<List<Integer>> levelOrder(TreeNode root) {
            List<List<Integer>> result = new ArrayList<>();

            Queue<TreeNode> queue = new LinkedList<>();
            queue.add(root);
            while (!queue.isEmpty()) {
                int size = queue.size();
                List<Integer> temp = new ArrayList<>();
                for (int i = 0; i < size; i++) {
                    TreeNode front = queue.poll();
                    if (front != null) {
                        temp.add(front.val);
                        queue.add(front.left);
                        queue.add(front.right);
                    }
                }
                if (temp.size() > 0)
                    result.add(temp);
            }
            return result;
        }
    }
}
