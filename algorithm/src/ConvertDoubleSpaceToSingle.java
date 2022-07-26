public class ConvertDoubleSpaceToSingle {
    public static void main(String[] args) {
        String str = "string  with  double  spaces.";
        String output = Solution8.convertDoubleSpaceToSingle(str);
        System.out.println(output);
    }
}

// 문자열을 입력받아 해당 문자열에 등장하는 두 칸의 공백을 모두 한 칸의 공백으로 바꾼 문자열로 리턴
class Solution8 {
    public static String convertDoubleSpaceToSingle(String str) {
        return str.replace("  ", " ");
    }
}

/*
다른 풀이
class Solution8 {
    public static String convertDoubleSpaceToSingle(String str) {
        String[] arr = str.split("  ");
        return String.join(" ", arr);
    }
}*/
