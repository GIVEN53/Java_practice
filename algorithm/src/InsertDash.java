public class InsertDash {
    public static void main(String[] args) {
        String str = "0364649584527734248497490956436424513856401903589";

        String output = Solution14.insertDash(str);
        System.out.println(output);

    }
}

// 문자열을 입력받아 연속된 한자리 홀수 숫자 사이에 '-'를 추가한 문자열을 리턴
class Solution14 {
    public static String insertDash(String str) {
        if (str.length() == 0) {
            return null; // 빈 문자열
        }
        String result = "" + str.charAt(0);

        for (int i = 1; i < str.length(); i++) {
            int num = str.charAt(i) - '0'; // str 자릿수마다 int형으로 변환

            if (num%2 == 1) { // 홀수
               result = result + num + "-";
            }

            else { // 짝수
                if (result.charAt(result.length()-1) == '-') { // result 마지막이 '-' 이면
                    result = result.substring(0, result.length()-1); // '-' 지움
                }
                result += num;
            }
        }
        if (result.charAt(result.length()-1) == '-') {
            result = result.substring(0, result.length()-1);
        }
        return result;
    }
}