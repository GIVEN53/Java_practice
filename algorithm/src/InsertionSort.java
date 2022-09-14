import java.util.Arrays;

public class InsertionSort {
    public static void main(String[] args) {
        int[] arr = {20, 3, 6, 1, 8, 5, 4};

        int[] output = Solution49.insertionSort(arr);
        System.out.println(Arrays.toString(output));
    }
}

// 배열을 입력받아 오름차순으로 정렬
// 삽입 정렬
class Solution49 {
    public static int[] insertionSort(int[] arr) {
        for (int i = 1; i < arr.length; i++) {
            int j = i - 1;
            int temp = arr[i];

            while (j >= 0 && temp < arr[j]) {
                arr[j+1] = arr[j];
                j--;
            }
            arr[j+1] = temp;
        }
        return arr;
    }
}