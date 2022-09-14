import java.util.Arrays;

public class RadixSort {
    public static void main(String[] args) {
        int[] arr = {1, 2, 43, 100, 21};

        Solution50 obj = new Solution50();
        int[] output = obj.radixSort(arr);
        System.out.println(Arrays.toString(output));
    }
}

// 배열을 입력받아 오름차순으로 정렬
// 계수 정렬 -> 기수 정렬
class Solution50 {
    public int[] radixSort(int[] arr) { // 기수 정렬
        int max = arr[0];
        // 배열에서 최대값 찾기
        for (int i = 0; i < arr.length; i++) {
            if (max < arr[i]) {
                max = arr[i];
            }
        }

        // 자리수마다 정렬
        for (int digit = 1; digit <= max; digit *= 10) {
            arr = countingSort(arr, digit);
        }
        return arr;
    }

    public int[] countingSort(int[] arr, int digit) { // 계수 정렬
        int[] sortedArr = new int[arr.length];
        int[] countArr = new int[10];

        // 숫자 개수
        for (int i = 0; i < arr.length; i++) {
            countArr[(arr[i]/digit)%10]++;
        }

        // 누적 합
        for (int i = 1; i < countArr.length; i++) {
            countArr[i] += countArr[i-1];
        }

        // 뒤에서부터 정렬
        for (int i = arr.length - 1; i >= 0; i--) {
            int num = (arr[i]/digit)%10;
            countArr[num]--;
            sortedArr[countArr[num]] = arr[i];
        }
        return sortedArr;
    }
}
