import java.util.Arrays;

public class CreateMatrix {
    public static void main(String[] args) {
        int[][] matrix1 = {
                {0, 3, 0},
                {0, 2, 0},
                {1, 3, 0},
                {2, 1, 0}};
        int[][] output1 = Solution12.createMatrix(matrix1);
        System.out.println(Arrays.deepToString(output1));

        int[][] matrix2 = {
                {0, 2, 0},
                {2, 4, 1},
                {1, 3, 1},
                {2, 1, 0},};
        int[][] output2 = Solution12.createMatrix(matrix2);
        System.out.println(Arrays.deepToString(output2));
    }
}

// 방향이 있는 간선과 방향이 없는 간선들의 목록들을 받아 2차원 배열의 인접행렬 리턴
// index 0 : 시작 노드, index 1 : 도착 노드, index 2 : 방향성 (1==무방향, 0==방향)
class Solution12 {
    public static int[][] createMatrix(int[][] edges) {
        int n = 0;
        for (int[] edge : edges) {
            for (int i = 0; i < edge.length - 1; i++) {
                if (edge[i] > n) {
                    n = edge[i]; // 최대 노드 값 구하기
                }
            }
        }
        int[][] arr = new int[n+1][n+1]; // 노드 배열 생성

        for (int[] edge : edges) {
            int row = edge[0];
            int col = edge[1];

            if (edge[2] == 0) { // 방향 그래프
                arr[row][col] = 1;
            } else { // 무방향 그래프
                arr[row][col] = 1;
                arr[col][row] = 1;
            }
        }
        return arr;
    }
}