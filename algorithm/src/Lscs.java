public class Lscs {
    public static void main(String[] args) {
        int[] arr = {1, 2, 3, -7, 5};

        int output = Solution57.LSCS(arr);
        System.out.println(output);
    }
}

// 정수 배열을 입력받아 LSCS를 리턴
// LSCS : 연속된 부분 배열의 합 중 가장 큰 값
class Solution57 {
    public static int LSCS(int[] arr) {
        int[] dp = new int[arr.length];
        dp[0] = arr[0];
        int max = arr[0];

        for (int i = 1; i < arr.length; i++) {
            if (dp[i - 1] > 0) {
                dp[i] = dp[i - 1] + arr[i];
            } else {
                dp[i] = arr[i];
            }

            if (dp[i] > max) {
                max = dp[i];
            }
        }
        return max;
    }
}
