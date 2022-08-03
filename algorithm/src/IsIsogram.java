import java.util.*;

public class IsIsogram {
    public static void main(String[] args) {
        String str = "Dermatoglyphics";
        boolean output = Solution29.isIsogram(str);
        System.out.println(output);
    }
}

// 문자열을 입력받아 아이소그램인지 여부를 리턴
// isogram : 각 알파벳을 한번씩만 사용해서 만든 단어나 문구
class Solution29 {
    public static boolean isIsogram(String str) {
        str = str.toLowerCase();

        for (int i = 0; i < str.length()-1; i++) {
            String alphabet = "" + str.charAt(i);
            String compareStr = str.substring(i+1);
            if (compareStr.contains(alphabet)) return false;
        }
        return true;
    }
}
/*
for문 돌 때마다 String 객체가 계속 생겨서 메모리를 잡아먹지 않을까? -> ArrayList 사용

        List<Character> compareList = new ArrayList<>();
        for (int i = 0; i < str.length(); i++) {
            if (compareList.contains(str.charAt(i))) return false;
            compareList.add(str.charAt(i));
        }
        return true;
 */