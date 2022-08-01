public class ABCheck {
    public static void main(String[] args) {
        String str = "HK9J6YjrAcMbq8qKrbS3EaPRT";
        boolean output = Solution9.ABCheck(str);
        System.out.println(output);
    }
}

// 문자열을 입력받아 문자열 내에 아래 중 하나가 존재하는지 여부를 리턴
// 1. 'a'로 시작해서 'b'로 끝나는 길이 5의 문자열
// 2. 'b'로 시작해서 'a'로 끝나는 길이 5의 문자열
class Solution9 {
    public static boolean ABCheck(String str) {
        str = str.replace('A', 'a').replace('B', 'b'); // 소문자로 치환

        for (int i = 4; i < str.length(); i++) {
            if ((str.charAt(i) == 'a' && str.charAt(i-4) == 'b') ||
                    (str.charAt(i) == 'b' && str.charAt(i-4) == 'a')) {
                return true;
            }
        }
        return false;
    }
}
