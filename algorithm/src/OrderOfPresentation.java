import java.util.ArrayList;
import java.util.Arrays;

public class OrderOfPresentation {
    public static void main(String[] args) {
        Solution45 obj = new Solution45();
        int[] arr = {2, 3, 1};

        int output = obj.orderOfPresentation(3, arr);
        System.out.println(output);
    }
}

// 조의 수 N과 발표 순서 K가 주어질 때 발표 순서 경우의 수 중 몇 번째인지 리턴
// 발표 순서 경우의 수는 오름차순, 0번째부터 시작
class Solution45 {
    public int orderOfPresentation(int N, int[] K) {
        ArrayList<int[]> numList = new ArrayList<>();
        boolean[] visited = new boolean[N+1];
        numList = combination(0, N, new int[N], visited, numList);

        return check(numList, K);
    }

    public ArrayList<int[]> combination(int n, int r, int[] arr, boolean[] visited, ArrayList<int[]> result) {
        if (n == r) {
            result.add(arr);
            return result;
        }

        for (int i = 1; i <= r; i++) {
            if (!visited[i]) {
                visited[i] = true;
                arr[n] = i;
                int[] copyArr = Arrays.copyOf(arr, arr.length);
                result = combination(n+1, r, copyArr, visited, result);
                visited[i] = false;
            }
        }
        return result;
    }

    public int check(ArrayList<int[]> list, int[] arr) {
        int index = 0;
        for (int[] listArr : list) {
            if(Arrays.equals(listArr, arr)) index = list.indexOf(listArr);
        }

        return index;
    }

    // 다른 풀이
    // 1 <= N <= 12 이므로 N이 12일 때 모든 순열을 구하면 수행 시간이 기하급수적으로 커지게 된다.
    // 따라서 나의 풀이와 같이 모든 순열을 구하는 것은 옳지 못함.
//    public int orderOfPresentation(int N, int[] K) {
//        int order = 0;
//        boolean[] isUsed = new boolean[N + 1];
//
//        for (int i = 0; i < K.length; i++) {
//            int num = K[i];
//            isUsed[num] = true;
//            boolean[] candidates = Arrays.copyOfRange(isUsed, 1, num);
//            int validCnt = 0;
//
//            for (boolean candidate : candidates) {
//                if (!candidate) validCnt++;
//            }
//
//            int formerCnt = validCnt * factorial(N - i - 1);
//            order += formerCnt;
//        }
//        return order;
//    }
//    public int factorial(int n) {
//        if(n <= 1) return 1;
//        return n * factorial(n - 1);
//    }
}
