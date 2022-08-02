public class Modulo {
    public static void main(String[] args) {
        Integer output = Solution28.modulo(123, 4);
        System.out.println(output);
    }
}

// 두 수를 입력받아, num1을 num2로 나눈 나머지를 리턴
// /, % 사용불가
class Solution28 {
    public static Integer modulo(int num1, int num2) {
        if (num1 == 0) return 0;
        if (num2 == 0) return null;

        while (num1 >= num2) {
            num1 -= num2;
        }
        return num1;
    }
}
