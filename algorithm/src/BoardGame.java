import java.util.*;

public class BoardGame {
    public static void main(String[] args) {
        int[][] board = {
            {0, 0, 0, 1},
            {1, 1, 1, 0},
            {1, 1, 0, 0},
            {0, 0, 0, 0}};
        String operation = "RRDLLD";
//        int[][] board = {
//                {0, 0, 1},
//                {1, 1, 1},
//                {1, 0, 0}
//        };
//        String operation = "UUUDD";

        Solution18 output = new Solution18();
        System.out.println(output.boardGame(board, operation));
    }
}

class Solution18 {
    public Integer boardGame(int[][] board, String operation) {
        Queue<Character> queue = new LinkedList<>();
        for(int i=0; i < operation.length(); i++) {
            queue.add(operation.charAt(i)); // 조작 문자열 큐에 추가
        }

        int[] xy = {0, 0}; // 좌표
        int cnt = 0;
        try {
            while (queue.size() > 0) {
                char key = queue.poll();
                xy = control(key, xy);
                int x = xy[0];
                int y = xy[1];
                int location = board[x][y];
                if (location == 1) {
                    cnt++;
                }
            }
            return cnt;
        } catch (ArrayIndexOutOfBoundsException e) {
            return null; // board 배열을 벗어나면 예외처리
        }
    }
    int[] control(char key, int[] xy) {
        if (key == 'U') {xy[0]--;}
        else if (key == 'D') {xy[0]++;}
        else if (key == 'L') {xy[1]--;}
        else {xy[1]++;} // key == 'R'
        return xy;
    }
}