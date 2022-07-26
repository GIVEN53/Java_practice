public class FirstReverse {
    public static void main(String[] args) {
        String output = Solution5.firstReverse("reenigne erawtfos taerg a eb lliw uoy");
        System.out.println(output);
    }
}

// 문자열을 입력받아 순서가 뒤집힌 문자열을 리턴
class Solution5 {
    public static String firstReverse(String str) {
        String result = "";
        int size = str.length()-1;

        for (int i = 0; i <= size; i++) {
            result += str.charAt(size-i);
        }
        return result;
    }
}