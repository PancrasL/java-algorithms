package indi.pancras.labuladuo.datastructure.graph;

import java.util.ArrayList;

public class EquationPossible990 {
    class Solution {
        private int[] parent = new int[256];

        public boolean equationsPossible(String[] equations) {
            for (int i = 'a'; i <= 'z'; i++) {
                parent[i] = i;
            }
            ArrayList<String> notEquals = new ArrayList<>();
            for (String equation : equations) {
                if (equation.charAt(1) == '=') {
                    union(equation.charAt(0), equation.charAt(3));
                } else {
                    notEquals.add(equation);
                }
            }

            for (String notEqual : notEquals) {
                int left = notEqual.charAt(0);
                int right = notEqual.charAt(3);
                if (find(left) == find(right)) {
                    return false;
                }
            }
            return true;
        }

        private void union(int x, int y) {
            parent[find(x)] = y;
        }

        private int find(int x) {
            while (x != parent[x]) {
                parent[x] = parent[parent[x]];
                x = parent[x];
            }
            return x;
        }
    }
}
