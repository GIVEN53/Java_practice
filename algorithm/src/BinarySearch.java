public class BinarySearch {
    public static void main(String[] args) {
        int[] arr = {0, 1, 2, 3, 4, 5, 6};

        int output = Solution54.binarySearch(arr, 2);
        System.out.println(output);
    }
}

// 오름차순으로 정렬된 배열과 정수를 입력받아 정수의 인덱스를 리턴
// 이진탐색 O(logN)
class Solution54 {
    public static int binarySearch(int[] arr, int target) {
        int left = 0;
        int right = arr.length - 1;

        while (left <= right) {
            int mid = (left + right) / 2;

            if (arr[mid] == target) {
                return mid;
            } else if (arr[mid] > target) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return -1;
    }
}
