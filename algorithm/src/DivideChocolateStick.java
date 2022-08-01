import java.util.*;

public class DivideChocolateStick {
    public static void main(String[] args) {
        Solution25 obj = new Solution25();
        ArrayList<Integer[]> output = obj.divideChocolateStick(4, 8);

        for (Integer[] arr : output) {
            System.out.println(Arrays.toString(arr));
        }
    }
}

// GCD 최대공약수
class Solution25 {
    public ArrayList<Integer[]> divideChocolateStick(int M, int N) {
        ArrayList<Integer[]> result = new ArrayList<>();
        Integer[] pepero = new Integer[3];

        int num = gcd(M, N); // 최대 공약수
        for (int i = 1; i <= num; i++) {
            if (num%i == 0) { // num의 약수
                result.add(new Integer[]{i, M/i, N/i});
            }
        }
        return result;

    }
    int gcd(int a, int b) {
        if(b==0) return a;
        return gcd(b, a%b);
    }
}
