import java.util.*;

public class ConnectedVertices {
    public static void main(String[] args) {
        int[][] arr = {
                {0, 1},
                {2, 3},
                {3, 4},
                {3, 5}};
        Solution13 output = new Solution13();
        System.out.println(output.connectedVertices(arr));

    }
}

// 방향이 없는 간선들의 목록이 주어질 때, 연결된 노드의 컴포넌트가 몇 개인지 리턴
class Solution13 {
    public int connectedVertices(int[][] edges) {
        int n = 0;
        for (int[] edge : edges) {
            for (int i : edge) {
                if (i > n) {
                    n = i; // 최대 노드 값 구하기
                }
            }
        }
        int[][] arr = new int[n+1][n+1]; // 노드 배열 arr 선언

        for (int[] edge : edges) {
            int row = edge[0];
            int col = edge[1];

            arr[row][col] = 1;
            arr[col][row] = 1;
        } // 무방향 arr 생성


        boolean[] visited = new boolean[arr.length]; // 지나간 노드 목록, 초기 값 {false, ...}
        int cnt = 0;

        for(int i = 0; i < visited.length; i++) {
            if (!visited[i]) { // 지나간 노드 목록에서 false일 때
                cnt++;
                visited = bfsArray(arr, i, visited); // 메서드 실행 {t, t, f, f, f, f}
            }
        }
        return cnt;
    }

    boolean[] bfsArray(int[][] arr, int from, boolean[] visited) { // 연결 찾기 메서드
        Queue<Integer> queue = new LinkedList<>();
        queue.add(from);
        visited[from] = true;

        while (queue.size() > 0) {
            from = queue.poll();

            for (int i = 0; i < arr[from].length; i++) {
                if (arr[from][i] == 1 && !visited[i]) { // 연결되어 있고 해당 노드를 지나가지 않았을 때
                    queue.add(i);
                    visited[i] = true;
                }
            }
        }
        return visited;
    }
}
