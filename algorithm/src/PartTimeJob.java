import java.util.*;

public class PartTimeJob {
    public static void main(String[] args) {
        int ouput = Solution17.partTimeJob(4972);
        System.out.println(ouput);
    }
}

class Solution17 {
    public static int partTimeJob(int k) {
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
    }
}