package indi.pancras.labuladuo.bfs;

import java.util.LinkedList;
import java.util.Queue;

import indi.pancras.labuladuo.TreeNode;

public class LowestBstH111 {
    class Solution {
        public int minDepth(TreeNode root) {
            if (root == null) {
                return 0;
            }
            Queue<TreeNode> queue = new LinkedList<>();
            queue.add(root);
            int height = 0;
            boolean finish = false;
            while (!queue.isEmpty()) {
                int size = queue.size();
                height++;
                for (int i = 0; i < size; i++) {
                    TreeNode poll = queue.poll();
                    if (poll.left == null && poll.right == null) {
                        finish = true;
                        break;
                    }
                    if (poll.left != null) {
                        queue.add(poll.left);
                    }
                    if (poll.right!=null) {
                        queue.add(poll.right);
                    }
                }
                if (finish) {
                    break;
                }
            }
            return height;
        }
    }
}
