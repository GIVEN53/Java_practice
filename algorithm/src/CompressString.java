import java.util.*;

public class CompressString {
    public static void main(String[] args) {
        String str = "wwwggoppopppp";

        String output = Solution33.compressString(str);
        System.out.println(output);
    }
}

// 문자열을 입력받아 연속되는 문자가 있을 경우, 연속 구간을 반복되는 수와 문자로 조합한 형태로 압축한 문자열을 리턴
// 3개 이상 연속되는 문자만 압축
class Solution33 {
    public static String compressString(String str) {
        Queue<String> queue = new LinkedList<>();
        Collections.addAll(queue, str.split(""));

        StringBuilder builder = new StringBuilder();
        while (queue.size() > 0) {
            String chr = queue.poll(); // 문자를 꺼냄

            int cnt = 1; // 자기 자신 카운트
            while (queue.size() > 0) {
                if (chr.equals(queue.peek())) { // 맨 위의 문자와 같은 문자면
                    cnt++;
                    queue.poll(); // 문자 꺼냄
                }
                else { // 같은 문자가 아니면 하위 while문 탈출
                    break;
                }

            }
            if (cnt == 1) {
                builder.append(chr);
            } else if (cnt == 2) {
                builder.append(chr);
                builder.append(chr);
            }
            else {
                builder.append(cnt);
                builder.append(chr);
            }
        }
        return builder.toString();
    }
}
