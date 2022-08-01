public class ReadVertically {
    public static void main(String[] args) {
        String[] arr = {"YCDt", "oao", "unI"};

        String output = Solution21.readVertically(arr);
        System.out.println(output);
    }
}

// 문자열을 요소로 갖는 배열을 입력받아 문자열을 세로로 읽었을 때의 문자열을 리턴
class Solution21 {
    public static String readVertically(String[] arr) {
        int max = 0;
        for (String str : arr) {
            if (str.length() > max) {
                max = str.length(); // 문자열의 최대 길이
            }
        }

        StringBuilder result = new StringBuilder();
        for (int i = 0; i < max; i++) {
            for (String str : arr) {
                if (str.length() <= i) continue; // 문자열의 인덱스를 넘어가면 건너뜀
                result.append(str.charAt(i));
            }
        }
        return result.toString();
    }
}
