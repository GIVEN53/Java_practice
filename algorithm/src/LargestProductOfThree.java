import java.util.*;

public class LargestProductOfThree {
    public static void main(String[] args) {
        int[] arr = {-1,2,-5,7};

        Solution34 obj = new Solution34();
        int output = obj.largestProductOfThree(arr);
        System.out.println(output);
    }
}

// 정수를 요소로 갖는 배열을 입력받아 3개의 요소를 곱해 나올 수 있는 최대값을 리턴
// 배열의 요소는 음수와 0을 포함하는 정수
class Solution34 {
    public int largestProductOfThree(int[] arr) {
        ArrayList<Integer> result = new ArrayList<>();
        int[] temp = new int[3];

        result = combination(0, 3, 0, arr, temp, result);

        int max = Integer.MIN_VALUE;
        for (int num : result) {
            if (num > max) max = num; // 최대값 찾기
        }
        return max;
    }

    public ArrayList<Integer> combination(int n, int r, int start,int[] arr, int[] temp, ArrayList<Integer> result) { // 조합 메서드
        if(n==r) {
            return multiList(result, temp);
        }
        for (int i = start; i < arr.length; i++) {
            temp[n] = arr[i];
            int[] outcome = Arrays.copyOf(temp, temp.length);
            result = combination(n+1, r, i+1, arr, outcome, result);
        }
        return  result;
    }

    public ArrayList<Integer> multiList(ArrayList<Integer> result, int[] temp) {
        int sum = 1;
        for (int num : temp) {
            sum *= num; // 배열 요소의 곱
        }
        result.add(sum);
        return result;
    }
}
