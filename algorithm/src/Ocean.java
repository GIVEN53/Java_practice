public class Ocean {
    public static void main(String[] args) {
        int target = 100;
        int[] type = {10, 20 ,50};
        long output = Solution19.ocean(target, type);
        System.out.println(output);
    }
}

class Solution19 {
    public static long ocean(int target, int[] type) {
        long[] dp = new long[target+1];
        dp[0] = 1; // 현재 type으로 만들 수 있는 경우의 수
        for (int i = 0; i < type.length; i++) {
            for (int j = type[i]; j <= target; j++) {
                dp[j] = dp[j] + dp[j - type[i]];
            }
        }
        return dp[target];
    }
}

/*
초기 값
target : 10
type : {1, 3, 5}
dp : {1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0}

for문
i = 0 -> type : 1
j : 1부터 시작
dp : {1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1}
type 숫자로 각 인덱스를 만들 수 있는 경우의 수
1로 9나 10을 만들 수 있는 경우의 수는 1개

i = 1 -> type : 3
j : 3부터 시작
dp : {1, 1, 1, 2, 2, 2, 3, 3, 3, 4, 4}
만약 dp[4]를 구한다면 dp[4] + dp[1] = 1 + 1 = 2 -> 누적된 dp[4] + 3을 뺀 나머지의 경우의 수


i = 2 -> type : 5
j : 5부터 시작
dp : {1, 1, 1, 2, 2, 3, 4, 4, 5, 6, 7}

 */