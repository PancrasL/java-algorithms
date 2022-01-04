package indi.pancras.labuladuo.datastructure.binarytree;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import indi.pancras.labuladuo.TreeNode;

public class FindDuplicateSubTrees652 {
    static class Solution {
        private HashMap<String, TreeNode> treeMap = new HashMap<>();

        public List<TreeNode> findDuplicateSubtrees(TreeNode root) {
            Set<TreeNode> ans = new HashSet<>();
            postTraverse(root, ans);
            return new ArrayList<>(ans);
        }

        private String postTraverse(TreeNode root, Set<TreeNode> ans) {
            if (root == null) {
                return "#";
            }
            String leftSeq = postTraverse(root.left, ans);
            String rightSeq = postTraverse(root.right, ans);
            String rootSeq = leftSeq + "#" + rightSeq + "#" + root.val;
            if (treeMap.containsKey(rootSeq)) {
                ans.add(treeMap.get(rootSeq));
            } else {
                treeMap.put(rootSeq, root);
            }
            return rootSeq;
        }
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        TreeNode root = new TreeNode(2);
        root.left = new TreeNode(3);
        root.right = new TreeNode(3);
        List<TreeNode> ans = s.findDuplicateSubtrees(root);
        for (TreeNode node : ans) {
            System.out.println(node);
        }
    }
}
