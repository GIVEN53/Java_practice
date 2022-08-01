import java.util.*;

public class PartTimeJob {
    public static void main(String[] args) {
        int output = Solution17.partTimeJob(4972);
        System.out.println(output);
    }
}

// DP 최소 개수
// 거스름돈 k를 만드는 동전의 최소 개수를 리턴
class Solution17 {
/*    public static int partTimeJob(int k) {
        int[] coin = {500, 100, 50, 10, 5, 1}; // 가지고 있는 동전
        Queue<Integer> queue = new LinkedList<>();

        for (int n : coin) {
            queue.add(n); // 동전을 큐에 추가
        }

        int cnt = 0;
        while (queue.size() > 0) {
            int num = queue.poll();
            cnt = cnt + k/num; // 사용된 동전 개수
            k = k%num;
        }
        return cnt;
    }*/
    public static int partTimeJob(int k) {
        int[] dp = new int[k+1];
        Arrays.fill(dp, Integer.MAX_VALUE);
        dp[0] = 0;
        int[] coin = {1, 5, 10, 50, 100 ,500}; // 가지고 있는 동전

        for (int i = 0; i < coin.length; i++) {
            for (int j = coin[i]; j <= k; j++) {
                dp[j] = Math.min(dp[j], dp[j - coin[i]]+1);
            }
        }
        return dp[k];
    }
}

/*
초기 값
k : 10
coin : {1, 3, 5}
dp : {0, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?}
? = max값

for 문
i = 0 -> coin : 1
j : 1부터 시작
dp : {0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10}

i = 1 -> coin : 3
j : 3부터 시작
dp : {0, 1, 2, 1, 2, 3, 2, 3, 4, 3, 4}

i = 2 -> coin : 5
j : 5부터 시작
dp : {0, 1, 2, 1, 2, 1, 2, 3, 2, 3, 2}
 */