package indi.pancras.offer;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

import indi.pancras.TreeNode;

public class LevelOrder32 {
    class Solution {
        public int[] levelOrder(TreeNode root) {
            if (root == null) {
                return new int[0];
            }
            List<Integer> result = new ArrayList<>();
            Queue<TreeNode> queue = new LinkedList<>();
            queue.add(root);
            while (!queue.isEmpty()) {
                int size = queue.size();
                for (int i = 0; i < size; i++) {
                    TreeNode node = queue.poll();
                    result.add(node.val);
                    if (node.left != null) {
                        queue.add(node.left);
                    }
                    if (node.right != null) {
                        queue.add(node.right);
                    }
                }
            }

            int[] res = new int[result.size()];
            for (int i = 0; i < res.length; i++) {
                res[i] = result.get(i);
            }
            return res;
        }
    }
}
