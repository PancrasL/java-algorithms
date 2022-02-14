package indi.pancras.offer;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

import indi.pancras.TreeNode;

public class LevelOrderThree32 {
    class Solution {
        public List<List<Integer>> levelOrder(TreeNode root) {
            List<List<Integer>> result = new ArrayList<>();
            if (root == null) {
                return result;
            }
            Queue<TreeNode> queue = new LinkedList<>();
            queue.add(root);
            boolean leftToRight = true;
            while (!queue.isEmpty()) {
                int size = queue.size();
                ArrayList<Integer> levelValue = new ArrayList<>();
                for (int i = 0; i < size; i++) {
                    TreeNode node = queue.poll();
                    levelValue.add(node.val);
                    if (node.left != null) {
                        queue.add(node.left);
                    }
                    if (node.right != null) {
                        queue.add(node.right);
                    }
                }
                if (!leftToRight) {
                    Collections.reverse(levelValue);
                }
                leftToRight = !leftToRight;
                result.add(levelValue);
            }

            return result;
        }
    }
}
