import java.util.LinkedList;
import java.util.Queue;
import java.util.stream.Stream;

public class PrimePassword {
    public static void main(String[] args) {
        Solution53 obj = new Solution53();
        int output = obj.primePassword(9787, 9923);
        System.out.println(output);
    }
}

// 현재의 비밀번호를 새 비밀번호를 변경하는 데 필요한 최소 동작 수를 리턴
// 한 번에 한 개의 숫자만 변경 가능
// 4자리의 소수인 비밀번호로만 변경가능
class Solution53 {
    public int primePassword(int curPwd, int newPwd) {
        if (curPwd == newPwd) return 0;

        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{0,curPwd});

        boolean[] isVisited = new boolean[10000];
        isVisited[curPwd] = true;

        while (!queue.isEmpty()) {
            int[] data = queue.poll();
            int cnt = data[0];
            int num = data[1];

            // 각 자리수 반복
            for (int i = 0; i < 4; i++) {
                int[] curPwdArr = cuttingPwd(num);

                // 0 ~ 9까지 반복
                for (int j = 0; j < 10; j++) {
                    if (j != curPwdArr[i]) {
                        curPwdArr[i] = j;
                        int next = createNewPwd(curPwdArr);

                        if(next == newPwd) return ++cnt;

                        if (next > 1000 && checkPrime(next) && !isVisited[next]) {
                            isVisited[next] = true;
                            queue.add(new int[]{cnt+1, next});
                        }
                    }
                }
            }
        }
        return -1;
    }

    // 소수 판별
    private boolean checkPrime(int num) {
        if(num%2 == 0) return false;
        for (int i = 3; i <= Math.sqrt(num); i+=2) {
            if (num%i == 0) {
                return false;
            }
        }
        return true;
    }

    // 1234 -> [1, 2, 3, 4]
    private int[] cuttingPwd(int pwd) {
//        int[] arr = new int[4];
//
//        for (int i = 0; i < 4; i++) {
//            arr[i] = (int) (pwd / Math.pow(10, 3-i));
//            pwd %= Math.pow(10, 3-i);
//        }
//        return arr;
        return Stream.of(String.valueOf(pwd).split(""))
                .mapToInt(Integer::parseInt).toArray();
    }

    // [1, 2, 3, 4] -> 1234
    private int createNewPwd(int[] arr) {
        int pwd = 0;
        for (int i = 0; i < 4; i++) {
            pwd = (int) (pwd + arr[i] * Math.pow(10, 3 - i));
        }
        return pwd;
    }
}
