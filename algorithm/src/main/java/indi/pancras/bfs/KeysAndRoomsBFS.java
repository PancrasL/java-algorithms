package indi.pancras.bfs;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @author pancras
 * @解题思路 bfs
 * @create 2021/3/25 10:57
 * @see <a href="https://leetcode-cn.com/leetbook/read/queue-stack/gle1r/">钥匙和房间</a>
 */
public class KeysAndRoomsBFS {
    public boolean run(List<List<Integer>> rooms) {
        return new Solution().canVisitAllRooms(rooms);
    }

    class Solution {
        public boolean canVisitAllRooms(List<List<Integer>> rooms) {
            if (rooms == null || rooms.size() == 0) {
                return false;
            }

            int openRoomsCnt = 0;
            boolean[] visited = new boolean[rooms.size()];
            Queue<Integer> q = new LinkedList<>();

            visited[0] = true;
            openRoomsCnt++;
            q.add(0);
            while (!q.isEmpty()) {
                int front = q.poll();
                for (Integer next : rooms.get(front)) {
                    if (!visited[next]) {
                        visited[next] = true;
                        openRoomsCnt++;
                        q.add(next);
                    }
                }
            }

            return openRoomsCnt == rooms.size();
        }
    }
}
