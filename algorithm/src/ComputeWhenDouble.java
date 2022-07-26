public class ComputeWhenDouble {
    public static void main(String[] args) {
        int output = Solution2.computeWhenDouble(7);
        System.out.println(output);
    }
}

// 연이율을 입력받아 원금이 2배 이상이 될 때까지 걸리는 시간(년)을 리턴
class Solution2 {
    public static int computeWhenDouble(double interestRate) {
        double rate = 1 + interestRate/100;
        double principal = 1;
        int year = 0;

        while (principal < 2) {
            year++;
            principal *= rate;
        }
        return year;
    }
}



/* 첫 번째 코드
class Solution {
    public int computeWhenDouble(double interestRate) {
        double principal = 1;
        double principalDouble = principal*2;
        int year = 0;

        while (true) {
            year++;
            principal = principal + principal * interestRate*0.01;

            if(principal >= principalDouble) {
                break;
            }
        }
        return year;
    }
}*/
