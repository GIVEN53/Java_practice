public class FirstCharacter {
    public static void main(String[] args) {
        String output = Solution4.firstCharacter("hello world");
        System.out.println(output);
    }
}

// 문자열을 입력받아 문자열을 구성하는 각 단어의 첫 글자로 이루어진 문자열을 리턴 (공백으로 구분)
class Solution4 {
    public static String firstCharacter(String str) {
        // TODO:
        if(str.length() == 0) {
            return "";
        }
        String[] word = str.split(" ");
        String firstConcat= "";

        for (int i = 0; i < word.length; i++) {
            firstConcat += word[i].charAt(0);
        }
        return firstConcat;
    }
}
