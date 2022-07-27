public class ABCheck {
    public static void main(String[] args) {
        String str = "HK9J6YjrAcMbq8qKrbS3EaPRT";
        boolean output = Solution9.ABCheck(str);
        System.out.println(output);
    }
}

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
