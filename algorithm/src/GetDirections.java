import java.util.*;

public class GetDirections {
    public static void main(String[] args) {
        int[][] matrix1 = {
                {0, 1, 0 ,0},
                {0, 0, 1, 0},
                {0, 0, 0, 1},
                {0, 1, 0, 0}};
        boolean output1 = Solution11.getDirections(matrix1, 0, 2);
        System.out.println(output1);

        int[][] matrix2 = {
                {0, 1, 0, 0, 0},
                {0, 0, 0, 1, 0},
                {0, 1, 0, 0, 0},
                {0, 1, 1, 0, 0},
                {1, 1, 1, 1, 0}};
        boolean output2 = Solution11.getDirections(matrix2, 1, 4);
        System.out.println(output2);
    }
}

// 주어진 인접행렬에서 from노드에서 to노드로 이어지는 길이 존재하는지 리턴 (Graph)
// 지나간 노드는 다시 돌아갈 수 없다.
class Solution11 {
    public static boolean getDirections(int[][] matrix, int from, int to) {
        Queue<Integer> queue = new LinkedList<>();
        queue.add(from); // 첫 노드

        boolean[] visited = new boolean[matrix.length]; // 지나간 노드 목록, 초기 값 {false, ...}
        visited[from] = true;

        while(queue.size() > 0) {
            from = queue.poll();
            if(from == to) return true;

            for(int i = 0; i < matrix[from].length; i++) {
                if(matrix[from][i] == 1 && !visited[i]) {
                    queue.add(i); // 다음 노드로 변경
                    visited[i] = true; // 방문 노드로 저장
                }
            }
        }
        return false;
    }
}