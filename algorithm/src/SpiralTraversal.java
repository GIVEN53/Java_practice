public class SpiralTraversal {
    public static void main(String[] args) {
        Character[][] matrix = {
                {'T', 'y', 'r', 'i'},
                {'i', 's', 't', 'o'},
                {'n', 'r', 'e', 'n'},
                {'n', 'a', 'L', ' '},
        };

        String output = Solution56.spiralTraversal(matrix);
        System.out.println(output);

    }
}

// 2차원 MxN 배열을 나선형으로 순회
// 배열의 모든 요소를 순서대로 이어붙인 문자열을 리턴
class Solution56 {
    public static String spiralTraversal(Character[][] matrix) {
        int m = matrix[0].length; // 가로
        int n = matrix.length; // 세로
        boolean[][] isVisited = new boolean[n][m];
        int[] curLocation = {0, -1};

        StringBuilder builder = new StringBuilder();
        while (builder.length() < (m * n)) {

            // 오른쪽
            int right = ++curLocation[1];
            while (right <= m - 1 && !isVisited[curLocation[0]][right]) {
                builder.append(matrix[curLocation[0]][right].toString());
                isVisited[curLocation[0]][right] = true;
                right++;
                curLocation[1]++;
            }
            curLocation[1]--; // 한칸 더 나가서 index out이므로 한칸 감소시켜줌

            // 아래
            int down = ++curLocation[0];
            while (down <= n - 1 && !isVisited[down][curLocation[1]]) {
                builder.append(matrix[down][curLocation[1]].toString());
                isVisited[down][curLocation[1]] = true;
                down++;
                curLocation[0]++;
            }
            curLocation[0]--;

            // 왼쪽
            int left = --curLocation[1];
            while (left >= 0 && !isVisited[curLocation[0]][left]) {
                builder.append(matrix[curLocation[0]][left].toString());
                isVisited[curLocation[0]][left] = true;
                left--;
                curLocation[1]--;
            }
            curLocation[1]++;

            // 위
            int up = --curLocation[0];
            while (up >= 0 && !isVisited[up][curLocation[1]]) {
                builder.append(matrix[up][curLocation[1]].toString());
                isVisited[up][curLocation[1]] = true;
                up--;
                curLocation[0]--;
            }
            curLocation[0]++;
        }
        return builder.toString();
    }
}
