public class LetterCapitalize {
    public static void main(String[] args) {
        String output = Solution6.letterCapitalize("java is good");
        System.out.println(output);
    }
}

// 문자열을 입력받아 문자열을 구성하는 각 단어의 첫 글자가 대문자인 문자열을 리턴
class Solution6 {
    public static String letterCapitalize(String str) {
        String result = "";
        int cnt = 0;

        for (int i = 0; i < str.length(); i++) {
            if (i == 0 || str.charAt(i-1) == ' ') {
                result += Character.toUpperCase(str.charAt(i));
            }
            else {
                result += str.charAt(i);
            }

            if (str.charAt(i) != ' ') {cnt+=1;}
        }

        if (cnt == 0) {return "";}
        return result;
    }
}

