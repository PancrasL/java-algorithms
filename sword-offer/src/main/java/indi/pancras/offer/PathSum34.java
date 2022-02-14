package indi.pancras.offer;

import java.util.ArrayList;
import java.util.List;

import indi.pancras.TreeNode;

public class PathSum34 {
    class Solution {
        List<List<Integer>> result = new ArrayList<>();

        public List<List<Integer>> pathSum(TreeNode root, int target) {
            if (root == null) {
                return result;
            }
            dfs(root, 0, target, new ArrayList<>());
            return result;
        }

        private void dfs(TreeNode root, int sum, int target, List<Integer> path) {
            if (root.left == null && root.right == null) {
                if (sum + root.val == target) {
                    ArrayList<Integer> validPath = new ArrayList<>(path);
                    validPath.add(root.val);
                    result.add(new ArrayList<>(validPath));
                }
                return;
            }
            sum += root.val;
            path.add(root.val);
            if (root.left != null)
                dfs(root.left, sum, target, path);
            if (root.right != null)
                dfs(root.right, sum, target, path);
            sum -= root.val;
            path.remove(path.size() - 1);
        }
    }
}
