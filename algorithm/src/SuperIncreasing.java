public class SuperIncreasing {
    public static void main(String[] args) {
        int[] arr = {-2247, 1093, 1064};
        boolean output = Solution27.superIncreasing(arr);
        System.out.println(output);
    }
}

// 각 요소들이 그 이전의 요소들의 합보다 큰지 여부를 리턴
class Solution27 {
    public static boolean superIncreasing(int[] arr) {
        int sum = arr[0];
        for (int i = 1; i < arr.length; i++) {
            if (sum >= arr[i]) {return false;}
            sum += arr[i];
        }
        return true;
    }
}
