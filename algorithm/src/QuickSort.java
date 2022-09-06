import java.util.Arrays;

public class QuickSort {
    public static void main(String[] args) {
        Solution48 obj = new Solution48();
        int[] arr = {20, -10, -11, 2, 29};

        int[] result = obj.quickSort(arr);
        System.out.println(Arrays.toString(result));
    }
}

// 배열을 입력받아 오름차순으로 정렬
// 퀵 정렬
class Solution48 {
    public int[] quickSort(int[] arr) {
        if (arr.length == 0) return arr;

        int left = 0;
        int right = arr.length-1;

        return sort(arr, left, right);
    }

    private int[] sort(int[] arr, int left, int right) {
        if (left >= right) return arr;

        int p = partition(arr, left, right); // pivot 인덱스 찾기
        arr = sort(arr, p + 1, right);
        arr = sort(arr, left, p - 1);
        return arr;
    }

    private int partition(int[] arr, int left, int right) {
        int pivot = arr[right];
        int highIndex = left - 1;

        for (int i = left; i < right; i++) {
            if (arr[i] <= pivot) {
                highIndex++;
                swap(arr, highIndex, i);
            }
        }
        swap(arr, highIndex+1, right);
        return highIndex+1; // 기준 인덱스
    }

    private void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}