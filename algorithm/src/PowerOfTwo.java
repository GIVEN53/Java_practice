public class PowerOfTwo {
    public static void main(String[] args) {
        boolean output = Solution3.powerOfTwo(16);
        System.out.println(output);
    }
}

// 수를 입력받아 2의 거듭제곱인지 여부를 리턴
class Solution3 {
    public static boolean powerOfTwo(long num) {
        while (num > 0) {
            if (num == 1) {
                break;
            }
            if (num % 2 == 1) {
                return false;
            }
            num /= 2;
        }
        return true;
    }
}
