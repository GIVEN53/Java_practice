import java.util.*;

public class BubbleSort {
    public static void main(String[] args) {
        int[] arr = {6, -1, 5, 7, 10, 3, 2, 21, 33, 1, -8, 11};
        int[] output = Solution35.bubbleSort(arr);
        System.out.println(Arrays.toString(output));
    }
}

// 버블정렬 알고리즘으로 오름차순 정렬하여 리턴
class Solution35 {
    public static int[] bubbleSort(int[] arr) {
        for (int i = 0; i < arr.length; i++) { // 배열 크기만큼 반복
            for (int j = 1; j < arr.length - i; j++) { // 상위 for문 돌때마다 정렬된 요소는 보지않음
                if (arr[j-1] > arr[j]) {
                    int temp = arr[j-1];
                    arr[j-1] = arr[j];
                    arr[j] = temp;
                }
            }
        }
        return arr;
    }
}