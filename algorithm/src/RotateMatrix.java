import java.util.Arrays;

public class RotateMatrix {
    public static void main(String[] args) {
//        int[][] matrix = {
//                {1, 2, 3, 4},
//                {5, 6, 7, 8},
//                {9, 10, 11, 12},
//                {13, 14, 15, 16}
//        };
        int[][] matrix = {
                {1, 2, 3},
                {4, 5, 6},
                {7, 8, 9},
                {10, 11, 12}
        };
        int K = 1;

        int[][] output = Solution47.rotateMatrix(matrix, K);
        System.out.println(Arrays.deepToString(output));
    }
}

// 2차원 MXN 배열을 시계 방향으로 90도 회전시킨 배열을 리턴
// K는 회전 횟수
class Solution47 {
    public static int[][] rotateMatrix(int[][] matrix, int K) {
        if (K == 0 || matrix == null) {
            return matrix;
        }

        int row = matrix.length;
        int col = matrix[0].length;
        int[][] newMatrix = new int[col][row];

        for (int i = 0; i < row; i++) {
            int[] arr = matrix[i];
            for (int j = 0; j < col; j++) {
                newMatrix[j][row-i-1] = arr[j];
            }
        }

        return rotateMatrix(newMatrix, K-1);
    }
}