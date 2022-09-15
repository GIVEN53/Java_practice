import java.util.Arrays;

public class MergeSort {
    public static void main(String[] args) {
        int[] arr = {7, 6, 5, 8, 3, 5, 9, 1};

        Solution51 obj = new Solution51();
        int[] output = obj.mergeSort(arr);
        System.out.println(Arrays.toString(output));
    }
}

// 배열을 입력받아 오름차순으로 정렬
// 병합 정렬
class Solution51 {
    public int[] mergeSort(int[] arr) {
        arr = sort(arr, 0, arr.length-1);
        return arr;
    }

    public int[] sort(int[] arr, int start, int end) {
        if (start >= end) {
            return arr;
        }

        int mid = (start + end) / 2;
        arr = sort(arr, start, mid);
        arr = sort(arr, mid+1, end);

        int[] sortedArr = new int[arr.length]; // 정렬된 값을 삽입할 빈 배열
        arr = merge(arr, start, mid, end, sortedArr);

        return arr;
    }

    public int[] merge(int[] arr, int start, int mid, int end, int[] sortedArr) {
        int i = start;
        int j = mid + 1;
        int k = start;

        while (i <= mid && j <= end) {
            if (arr[i] <= arr[j]) {
                sortedArr[k++] = arr[i++];
            } else {
                sortedArr[k++] = arr[j++];
            }
        }

        // 남은 데이터 삽입
        if (i > mid) {
            for (int t = j; t <= end; t++) {
                sortedArr[k++] = arr[t];
            }
        } else {
            for (int t = i; t <= mid; t++) {
                sortedArr[k++] = arr[t];
            }
        }

        // 정렬된 배열 삽입
        for (int t = start; t <= end; t++) {
            arr[t] = sortedArr[t];
        }

        return arr;
    }
}