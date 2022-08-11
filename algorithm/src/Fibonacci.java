public class Fibonacci {
    public static void main(String[] args) {
        Solution36 obj = new Solution36();

        int output = obj.fibonacci(9);
        System.out.println(output);
    }
}

// 피보자치 수열중 n번째 항의 수를 리턴
// 재귀함수 사용
class Solution36 {
    public int fibonacci(int num) {
        int[] fiboArr = new int[num+1]; // 피보나치수열을 담을 배열 생성
        return memo(fiboArr, num);
    }

    // DP를 사용하여 작은 문제의 결괏값을 저장
    public int memo(int[] arr, int n) {
        if (n < 2) return arr[n] = n; // n이 0 또는 1일 때
        if (arr[n] > 0) return arr[n]; // 이미 계산된 값이 있으면 바로 리턴

        return arr[n] = memo(arr, n-1) + memo(arr, n-2);
    }
}