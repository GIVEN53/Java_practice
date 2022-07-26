import java.util.Arrays;

public class Fibonacci {
    public static void main(String[] args) {
        int num = 8; //scan으로 바꾸기
        int[] arr = new int [num+1];

        for (int i =0; i < num+1; i++)
            if (i <= 1) {
                arr[i] = i;
            } else {
                arr[i] = arr[i - 2] + arr[i - 1];
            }
        System.out.println(Arrays.toString(arr));
    }
}
