public class NumberSearch {
    public static void main(String[] args) {
        String str = "Hello6 9World 2, Nic8e D7ay!";
        int output = Solution31.numberSearch(str);
        System.out.println(output);
    }
}

// 문자열에서 숫자를 모두 찾아 더한 뒤 해당 값을 문자열(숫자와 공백을 제외한 나머지)의 길이로 나눈 값을 정수로 반올림하여 리턴
class Solution31 {
    public static int numberSearch(String str) {
        if (str.length() == 0) return 0; // 빈 문자열은 0 리턴

        String intStr = str.replaceAll("[^\\d]", ""); // 숫자만 추출
        str = str.replaceAll("[\\d]", "").replaceAll(" ", ""); // 문자열만 추출

        float sum = 0;
        for (int i = 0; i < intStr.length(); i++) {
            sum = sum + (intStr.charAt(i) - '0'); // 숫자문자열의 합
        }

        float length = str.length(); // 문자열의 길이
        return Math.round(sum/length); // 정수 반올림
    }
}