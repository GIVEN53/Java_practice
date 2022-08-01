import java.util.*;

public class ReverseArr {
    public static void main(String[] args) {
        int[] arr = {-1, -2, 1, 2, 3, 4, 5};
        int[] output = Solution20.reverseArr(arr);
        System.out.println(Arrays.toString(output));
    }
}

// 배열을 입력받아 순서가 뒤집힌 배열을 리턴
class Solution20 {
    public static int[] reverseArr(int[] arr) {
        if (arr.length == 0) {return arr;}

        int head = arr[arr.length-1];
        int[] tail = reverseArr(Arrays.copyOfRange(arr, 0, arr.length-1));

        int[] dest = new int[arr.length];
        dest[0] = head;
        System.arraycopy(tail, 0, dest, 1, tail.length);
        return dest;
    }
}
