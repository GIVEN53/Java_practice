import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class RobotPath2 {
    public static void main(String[] args) {
        int[][] room = {
                {0,0,0,0},
                {0,1,1,0},
                {0,1,0,0},
                {0,0,1,1}
        };
        int[] src = {3, 0};
        int sDir = 3;
        int[] dst = {2, 2};
        int dDir = 2;

        Solution58 obj = new Solution58();
        int output = obj.robotPath2(room, src, sDir, dst, dDir);
        System.out.println(output);
    }
}

// MxN인 2차원 배열에서 1은 장애물, 0은 이동 가능한 통로를 의미
// 로봇은 한 번에 임의의 k칸 직진과 90도 회전 중 1가지 동작을 할 수 있다. 방향은 위쪽 1, 오른쪽 2, 아래쪽 3, 왼쪽 4로 주어진다.
// 로봇이 목표 지점까지 도달하여 목표 방향으로 회전하는 데 필요한 동작의 수를 리턴
class Solution58 {
    public int robotPath2(int[][] room, int[] src, int sDir, int[] dst, int dDir) {
        int row = room.length;
        int col = room[0].length;

        int[][] directions = new int[row][col]; // 최소 동작으로 도달 가능한 경우의 방향
        int[][] actions = new int[row][col]; // 최소 동작 수
        int[][] moves = {
                {1, -1, 0}, // up
                {2, 0, 1}, // right
                {3, 1, 0}, // down
                {4, 0, -1} // left
        };

        for (int i = 0; i < row; i++) {
            Arrays.fill(actions[i], Integer.MAX_VALUE);
        }

        Queue<Integer[]> queue = new LinkedList<>();

        // 출발 지점
        int sRow = src[0];
        int sCol = src[1];
        directions[sRow][sCol] = sDir;
        actions[sRow][sCol] = 0;

        // 목표 지점
        int dRow = dst[0];
        int dCol = dst[1];
        queue.offer(new Integer[]{sRow, sCol});

        while (!queue.isEmpty()) {
            Integer[] data = queue.poll();
            sRow = data[0];
            sCol = data[1];
            int dir = directions[sRow][sCol];

            for (int[] move : moves) {
                // 이동할 좌표
                int nRow = sRow + move[1];
                int nCol = sCol + move[2];

                // 좌표를 벗어나거나, 장애물이 있을 때
                if (!checkValid(nRow, nCol, row, col) || room[nRow][nCol] == 1) {
                    continue;
                }

                // 방향 차이
                int dDiff = Math.abs(move[0] - dir);

                int candidate;
                if (dDiff == 0) {
                    candidate = checkValid(sRow, sCol, row, col) && actions[sRow][sCol] != 0 ? actions[sRow][sCol] : 1;
                } else if (dDiff == 2) {
                    candidate = actions[sRow][sCol] + 3;
                } else {
                    candidate = actions[sRow][sCol] + 2;
                }

                if (nRow == dRow && nCol == dCol) {
                    int eDiff = Math.abs(move[0] - dDir);
                    if (eDiff == 0) {
                        candidate += 0;
                    } else if (eDiff == 2) {
                        candidate += 2;
                    } else {
                        candidate += 1;
                    }
                }

                if (candidate < actions[nRow][nCol]) {
                    queue.offer(new Integer[]{nRow, nCol});
                    actions[nRow][nCol] = candidate;
                    directions[nRow][nCol] = move[0];
                }
            }
        }
        return actions[dRow][dCol];
    }

    private boolean checkValid(int nRow, int nCol, int row, int col) {
        return nRow >= 0 && nRow < row && nCol >= 0 && nCol < col;
    }
}
