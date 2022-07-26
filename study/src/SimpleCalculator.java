import java.util.Scanner;
public class SimpleCalculator {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        System.out.println("첫 번째 숫자를 입력하세요.");
        String str1 = scan.nextLine(); // 첫 번째 숫자 입력

        System.out.println("사칙연산자를 입력하세요.");
        String op = scan.nextLine(); // 사칙연산자 입력

        System.out.println("두 번째 숫자를 입력하세요.");
        String str2 = scan.nextLine(); // 두 번째 숫자 입력

        int num1 = Integer.parseInt(str1);
        int num2 = Integer.parseInt(str2);
        int result;

        if(op.equals("+")) { // Addition
            result = num1 + num2;
            System.out.printf("%d %s %d = %d",num1, op, num2, result);
        }
        else if(op.equals("-")) { // Subtraction
            result = num1 - num2;
            System.out.printf("%d %s %d = %d",num1, op, num2, result);
        }
        else if(op.equals("*")) { // Multiplication
            result = num1 * num2;
            System.out.printf("%d %s %d = %d",num1, op, num2, result);
        }
        else if(op.equals("/")) { // Division
            result = num1 / num2;
            System.out.printf("%d %s %d = %d",num1, op, num2, result);
        }
        else {
            System.out.println("Operator is not valid.");
        }

    }
}
