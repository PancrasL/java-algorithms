package indi.pancras.dfs;

/**
 * @author pancras
 * @解题思路 DFS
 * @create 2021/3/23 16:45
 * @see <a href="https://leetcode-cn.com/leetbook/read/queue-stack/g02cj/">图像渲染</a>
 */
public class FigureFill {

    class Solution {
        int oldColor;

        public int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
            if (newColor == image[sr][sc]) {
                return image;
            }
            oldColor = image[sr][sc];
            DFS(image, sr, sc, newColor);


            return image;
        }

        private void DFS(int[][] image, int sr, int sc, int newColor) {
            if (sr < 0 || sr >= image.length || sc < 0 || sc >= image[0].length || image[sr][sc] != oldColor) {
                return;
            }

            image[sr][sc] = newColor;
            DFS(image, sr - 1, sc, newColor);
            DFS(image, sr + 1, sc, newColor);
            DFS(image, sr, sc - 1, newColor);
            DFS(image, sr, sc + 1, newColor);
        }
    }
}
