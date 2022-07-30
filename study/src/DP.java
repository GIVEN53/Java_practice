import java.util.*;

public class DP {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("거스름돈 입력");
        int k = scanner.nextInt(); // 거스름 돈

        // 보유한 동전 종류
        int[] coin = {1, 3, 5};

        CoinExchange exchange = new CoinExchange();

        System.out.println("경우의 수 : " + exchange.numberCase(k, coin));
        System.out.println();
        System.out.println("최소 개수 : " + exchange.minCnt(k, coin));


    }
}

class CoinExchange { // 거스름돈
    public int numberCase(int k, int[] coin) { // 경우의 수
        int[] dp = new int[k+1];
        dp[0] = 1;
        for (int i = 0; i < coin.length; i++) {
            for (int j = coin[i]; j <= k; j++) {
                dp[j] = dp[j] + dp[j - coin[i]];
            }
            System.out.println(Arrays.toString(dp));
        }
        return dp[k];
    }

    public int minCnt(int k, int[] coin) { // 최소 개수
        int[] dp = new int[k+1];
        Arrays.fill(dp, Integer.MAX_VALUE);
        dp[0] = 0;
        for (int i = 0; i < coin.length; i++) {
            for (int j = coin[i]; j <= k; j++) {
                dp[j] = Math.min(dp[j],dp[j - coin[i]]+1);
            }
            System.out.println(Arrays.toString(dp));
        }
        return dp[k];
    }
}