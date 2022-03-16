package indi.pancras.labuladuo.bfs;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

public class SlidingPuzzle773 {
    public static void main(String[] args) {
        // 1
        int[][] board1 = new int[][]{
                {1, 2, 3}, {4, 0, 5}};
        // -1
        int[][] board2 = new int[][]{
                {1, 2, 3}, {5, 4, 0}};
        // 5
        int[][] board3 = new int[][]{
                {4, 1, 2}, {5, 0, 3}};
        // 14
        int[][] board4 = new int[][]{
                {3, 2, 4}, {1, 0, 5}};
        Solution s1 = new Solution();
        System.out.println(s1.slidingPuzzle(board1));
        Solution s2 = new Solution();
        System.out.println(s2.slidingPuzzle(board2));
        Solution s3 = new Solution();
        System.out.println(s3.slidingPuzzle(board3));
        Solution s4 = new Solution();
        System.out.println(s4.slidingPuzzle(board4));
    }

    static class Solution {
        private final Set<String> visit = new HashSet<>();
        private final String target = "123450";

        public int slidingPuzzle(int[][] board) {
            Queue<Node> queue = new LinkedList<>();
            int step = -1;
            int[] zeroPos = findZero(board);
            String s = serialize(board);
            visit.add(s);
            queue.add(new Node(board, zeroPos[0], zeroPos[1], s));
            while (!queue.isEmpty()) {
                int size = queue.size();
                step++;
                for (int i = 0; i < size; i++) {
                    Node n = queue.poll();
                    if (isTarget(n.serialize)) {
                        return step;
                    }
                    // 0和上交换
                    int[][] up = canSwap(n.board, n.zeroX, n.zeroY, n.zeroX - 1, n.zeroY);
                    if (up != null) {
                        String serial = serialize(up);
                        visit.add(serial);
                        queue.add(new Node(up, n.zeroX - 1, n.zeroY, serial));
                    }
                    // 0和下交换
                    int[][] down = canSwap(n.board, n.zeroX, n.zeroY, n.zeroX + 1, n.zeroY);
                    if (down != null) {
                        String serial = serialize(down);
                        visit.add(serial);
                        queue.add(new Node(down, n.zeroX + 1, n.zeroY, serial));
                    }

                    // 0和左交换
                    int[][] left = canSwap(n.board, n.zeroX, n.zeroY, n.zeroX, n.zeroY - 1);
                    if (left != null) {
                        String serial = serialize(left);
                        visit.add(serial);
                        queue.add(new Node(left, n.zeroX, n.zeroY - 1, serial));
                    }

                    // 0和右交换
                    int[][] right = canSwap(n.board, n.zeroX, n.zeroY, n.zeroX, n.zeroY + 1);
                    if (right != null) {
                        String serial = serialize(right);
                        visit.add(serial);
                        queue.add(new Node(right, n.zeroX, n.zeroY + 1, serial));
                    }
                }
            }
            return -1;
        }

        // i,j为的位置，i1，j1为0移动后的位置
        private int[][] canSwap(int[][] board, int i, int j, int i1, int j1) {
            // 移动到边界外，不合法
            if (!validBorder(i1, j1)) {
                return null;
            }
            int[][] cloneBoard = new int[board.length][board[0].length];
            for (int k = 0; k < board.length; k++) {
                for (int l = 0; l < board[0].length; l++) {
                    cloneBoard[k][l] = board[k][l];
                }
            }
            int temp = cloneBoard[i][j];
            cloneBoard[i][j] = cloneBoard[i1][j1];
            cloneBoard[i1][j1] = temp;
            String s = serialize(cloneBoard);
            // 已经访问过了
            if (visit.contains(s)) {
                return null;
            }
            return cloneBoard;
        }

        private int[] findZero(int[][] board) {
            for (int i = 0; i < board.length; i++) {
                for (int j = 0; j < board[0].length; j++) {
                    if (board[i][j] == 0) {
                        return new int[]{i, j};
                    }
                }
            }
            throw new IllegalStateException("Zero not exist");
        }

        private boolean isTarget(String s) {
            return s.equals(target);
        }

        private boolean validBorder(int i, int j) {
            return i >= 0 && i < 2 && j >= 0 && j < 3;
        }

        // 将当前的2*3棋盘序列化
        private String serialize(int[][] board) {
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < board.length; i++) {
                for (int j = 0; j < board[0].length; j++) {
                    sb.append(board[i][j]);
                }
            }
            return sb.toString();
        }

        class Node {
            int[][] board;
            int zeroX;
            int zeroY;
            String serialize;

            public Node(int[][] board, int zeroX, int zeroY, String serialize) {
                this.board = board;
                this.zeroX = zeroX;
                this.zeroY = zeroY;
                this.serialize = serialize;
            }
        }
    }
}
