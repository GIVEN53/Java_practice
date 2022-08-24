import java.util.Stack;

public class BalancedBrackets {
    public static void main(String[] args) {
        String str = "[(]{)}";

        Solution41 obj = new Solution41();
        boolean output = obj.balancedBrackets(str);
        System.out.println(output);
    }
}

// 문자열을 입력받아 문자열 내의 모든 괄호의 짝이 맞는지 리턴
class Solution41 {
    public boolean balancedBrackets(String str) {
        if (str.length() == 0) { // 빈 문자열은 true 리턴
            return true;
        }

        Stack<Character> stack = new Stack<>();

        for (int i = 0; i < str.length(); i++) {
            // stack이 비어있지 않거나 char과 stack top의 닫는 괄호가 같을 때
            if (!stack.empty() && str.charAt(i) == closeBracket(stack.peek())) {
                stack.pop();
            } else {
                stack.push(str.charAt(i));
            }
        }
        return stack.size() == 0;
    }

    public Character closeBracket(char bracket) {
        if (bracket == '[') {
            return ']';
        } else if (bracket == '{') {
            return '}';
        } else if (bracket == '(') {
            return ')';
        } else { // 닫는 괄호 인자를 받으면
            return '?';
        }
    }
}