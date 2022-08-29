import java.util.*;
import java.util.stream.Collectors;

public class PowerSet {
    public static void main(String[] args) {
        Solution44 obj = new Solution44();
        ArrayList<String> output = obj.powerSet("jump");

        System.out.println(output);
    }
}

// 하나의 집합을 의미하는 문자열을 입력받아 각 문자를 가지고 만들 수 있는 모든 부분집합을 리턴
// 멱집합
class Solution44 {
    public ArrayList<String> powerSet(String str) {
        // 중복 제거
        HashSet<String> hashSet = new HashSet<>();
        for (int i = 0; i < str.length(); i++) {
            hashSet.add(str.charAt(i) + "");
        }

        // 정렬
        String[] sortArr = hashSet.toArray(new String[0]);
        Arrays.sort(sortArr);

        // 문자열로 치환
        str = String.join("", sortArr);

        Stack<String> stack = new Stack<>();
        ArrayList<String> result = new ArrayList<>();

        result = set(stack, str, 0, result);
        result.sort(Comparator.naturalOrder());
        return result;
    }

    public ArrayList<String> set(Stack<String> stack, String str, int k, ArrayList<String> result) {
        if (k == str.length()) {
//            Stack<String> newStack = new Stack<>();
//            newStack.addAll(stack);
//
//            StringBuilder builder = new StringBuilder();
//            while (newStack.size() > 0) {
//                builder.append(newStack.pop());
//            }
//            result.add(builder.toString()); // 반대 순서로 합쳐짐

            String addStr = stack.toString()
                    .replace("[", "")
                    .replace("]", "")
                    .replace(", ", "");
            result.add(addStr);
            return result;
        }

        stack.push(str.charAt(k)+"");
        set(stack, str, k + 1, result);
        stack.pop();
        set(stack, str, k+1, result);
        return result;
    }
}