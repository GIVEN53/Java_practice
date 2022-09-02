public class RobotPath {
    public static void main(String[] args) {
        int[][] room = {
                {0, 0, 0, 0, 0, 0},
                {0, 1, 1, 0, 1, 0},
                {0, 1, 0, 0, 0, 0},
                {0, 0, 1, 1, 1, 0},
                {1, 0, 0, 0, 0, 0}
        };
        int[] src  = {4, 2};
        int[] dst  = {2, 2};

        Solution46 obj = new Solution46();
        int output = obj.robotPath(room, src, dst);
        System.out.println(output);
    }
}

// MxN의 2차월 배열에서 1은 장애물, 0은 이동 가능한 통로를 의미
// 1분에 한 칸씩 상하좌우로 이동할 수 있으며 출발지점(src)과 목표지점(dst)가 주어졌을 때 dst까지 도달하는데 걸리는 최소 시간을 리턴
class Solution46 {
    public int robotPath(int[][] room, int[] src, int[] dst) {
        room = move(room, src, 1);
        return room[dst[0]][dst[1]] - 1;
    }

    public int[][] move(int[][] room, int[] src, int time) {
        int roomRow = room.length;
        int roomCol = room[0].length;

        int row = src[0];
        int col = src[1];

        if (row < 0 || row >= roomRow || col < 0 || col >= roomCol) return room; // room을 벗어났을 때

        // 처음 온 좌표거나 이미 지니갔던 시간보다 내가 찍을 시간이 더 작을 때
        if (room[row][col] == 0 || room[row][col] > time) {
            room[row][col] = time;
        }
        // 장애물이거나 내가 찍을 시간이 더 클 때(이미 지니갔던 경로가 더 효율적이었음)
        else {
            return room;
        }

        room = move(room, new int[]{row-1, col}, time+1); // 위로 이동
        room = move(room, new int[]{row+1, col}, time+1); // 아래로 이동
        room = move(room, new int[]{row, col-1}, time+1); // 좌로 이동
        room = move(room, new int[]{row, col+1}, time+1); // 우로 이동

        return room;
    }
}
