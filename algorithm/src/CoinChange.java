import java.util.ArrayList;
import java.util.Arrays;

public class CoinChange {
    public static void main(String[] args) {
        Solution59 obj = new Solution59();
        int output = obj.coinChange(10, new int[]{1, 5});
        System.out.println(output);
    }
}

// 주어진 동전을 가지고 특정 금액을 만들 수 있는 모든 경우의 수를 리턴
class Solution59 {
    public int coinChange(int total, int[] coins) {
        ArrayList<Integer[]> memo = new ArrayList<>();
        for (int i = 0; i < total + 1; i++) {
            Integer[] arr = new Integer[coins.length];
            Arrays.fill(arr, -1);
            memo.add(arr);
        }
        return changeFrom(total, 0, coins, memo);
    }

    private int changeFrom(int left, int idx, int[] coins, ArrayList<Integer[]> memo) {
        if (left == 0) { // 목표 금액을 만들었을 때
            return 1;
        }
        if (left < 0) {
            return 0;
        }
        if (idx >= coins.length && left > 0) { // 실패
            return 0;
        }
        if (memo.get(left)[idx] != -1) {
            return memo.get(left)[idx];
        }

        memo.get(left)[idx] = changeFrom(left, idx + 1, coins, memo) + changeFrom(left - coins[idx], idx, coins, memo);
        return memo.get(left)[idx];
    }
}