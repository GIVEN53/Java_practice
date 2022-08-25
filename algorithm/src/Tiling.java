public class Tiling {
    public static void main(String[] args) {
        int output = Solution42.tiling(5);
        System.out.println(output);
    }
}

// 세로 길이 2, 가로 길이 n인 2xn 보드가 있다. 1x2, 2x1 크기의 타일을 가지고 이 보드를 채우는 모든 경우의 수를 리턴
class Solution42 {
    public static int tiling(int num) {
        if (num < 3) {
            return num;
        }

        int[] dp = new int[num+1];
        dp[0] = 0;
        dp[1] = 1;
        dp[2] = 2;
        for (int i = 3; i <= num; i++) {
            dp[i] = dp[i - 1] + dp[i - 2];
        }
        return dp[num];
    }
}
