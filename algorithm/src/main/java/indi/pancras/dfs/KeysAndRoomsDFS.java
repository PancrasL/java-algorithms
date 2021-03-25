package indi.pancras.dfs;

import java.util.List;

/**
 * @author pancras
 * @解题思路 dfs
 * @create 2021/3/25 11:16
 * @see <a href="https://leetcode-cn.com/leetbook/read/queue-stack/gle1r/">钥匙和房间</a>
 */
public class KeysAndRoomsDFS {
    public boolean run(List<List<Integer>> rooms) {
        return new Solution().canVisitAllRooms(rooms);
    }

    class Solution {
        public boolean canVisitAllRooms(List<List<Integer>> rooms) {
            if (rooms == null || rooms.size() == 0) {
                return false;
            }

            boolean[] visited = new boolean[rooms.size()];

            return dfs(rooms, 0, visited) == rooms.size();
        }

        private int dfs(List<List<Integer>> rooms, int id, boolean[] visited) {
            int result = 1;
            visited[id] = true;
            for (Integer next : rooms.get(id)) {
                if (!visited[next]) {
                    result += dfs(rooms, next, visited);
                }
            }

            return result;
        }
    }
}
