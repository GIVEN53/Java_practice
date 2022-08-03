public class ComputeSquareRoot {
    public static void main(String[] args) {
        String output = Solution30.computeSquareRoot(6);
        System.out.println(output);
    }
}

// 수를 입력받아 제곱근 값을 소수점 둘째 자리까지 리턴
// Math.sqrt() 사용 x
class Solution30 {
    public static String computeSquareRoot(int num) {
        String result;
        float x = 1.00f;

        for (int i = 0; i < 30; i++) { // 바빌로니아 점화식
            x = (x + num/x) / 2;
        }
        result = String.format("%.2f", x);
        return result;
    }
}
