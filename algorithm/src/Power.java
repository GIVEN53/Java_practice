public class Power {
    public static void main(String[] args) {
        long output = Solution38.power(4, 15);
        System.out.println(output);
        System.out.println(Math.pow(4, 15));
    }
}

// 두 수를 입력받아 거듭제곱을 리턴
// Math.pow 사용 불가, 시간복잡도 O(logN)을 만족족
class Solution38 {
    public static long power(int base, int exponent) {
        if (exponent == 0) {
            return 1;
        }

        long result = power(base, exponent/2);

        if(exponent%2 == 0) {
            return result * result;
        }

        else return result * result * base;
    }
}