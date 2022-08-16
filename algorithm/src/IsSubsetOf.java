import java.util.*;
import java.util.stream.Collectors;

public class IsSubsetOf {
    public static void main(String[] args) {
        int[] base = {1, 2, 3, 4, 5};
        int[] sample = {1, 3};
        boolean output = Solution37.isSubsetOf(base, sample);
        System.out.println(output);
    }
}

// 두 개의 배열을 입력받아 sample이 base의 부분집합인지 리턴
class Solution37 {
    /*
    public static boolean isSubsetOf(int[] base, int[] sample) {
        Arrays.sort(base);
        Arrays.sort(sample);

        if (base.length == sample.length) { // 배열 길이가 같으면 equals 메서드로 리턴
            return Arrays.equals(base, sample);
        }

        int cnt = 0;
        for (int num1 : base) {
            for (int num2 : sample) {
                if (num1 == num2) { // base에 속하는 sample 요소 카운트
                    cnt += 1;
                    break;
                }
            }
        }
        return cnt == sample.length; // 카운트와 sample의 길이가 같으면 true
    }
    */

    // 다른 풀이
    public static boolean isSubsetOf(int[] base, int[] sample) {
        List<Integer> baseList // int 배열은 Arrays.asList()로 변환할 수 없음
                = Arrays.stream(base)
                .boxed() // primitive -> wrapper
                .collect(Collectors.toList());

        for (int num : sample) {
            if (!baseList.contains(num)) return false;
        }
        return true;
    }
}
