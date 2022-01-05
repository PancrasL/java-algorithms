package indi.pancras.labuladuo.datastructure.bst;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import indi.pancras.labuladuo.TreeNode;

public class NumTreesTwo95 {
    class Solution {
        public List<TreeNode> generateTrees(int n) {
            return inorderTraverse(1, n);
        }

        public List<TreeNode> inorderTraverse(int start, int end) {
            if (start == end) {
                return Collections.singletonList(new TreeNode(start));
            }
            if (start > end) {
                return Collections.singletonList(null);
            }
            ArrayList<TreeNode> result = new ArrayList<>();
            for (int i = start; i <= end; i++) {
                List<TreeNode> leftChilds = inorderTraverse(start, i - 1);
                List<TreeNode> rightChilds = inorderTraverse(i + 1, end);
                for (TreeNode left : leftChilds) {
                    for (TreeNode right : rightChilds) {
                        TreeNode root = new TreeNode(i);
                        root.left = left;
                        root.right = right;
                        result.add(root);
                    }
                }
            }
            return result;
        }
    }
}
