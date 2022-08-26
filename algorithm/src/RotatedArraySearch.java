public class RotatedArraySearch {
    public static void main(String[] args) {
        int[] arr = {10, 11, 12, 3, 6, 7, 8, 9};
        int output = Solution43.rotatedArraySearch(arr, 11);
        System.out.println(output);
    }
}

// 부분적으로 오름차순 정렬된 배열과 정수를 입력받아 정수의 인덱스를 리턴
// O(logN)
class Solution43 {
    public static int rotatedArraySearch(int[] rotated, int target) {
        // index
        int row = 0;
        int high = rotated.length -1;

        while (row <= high) {
            int mid = (row+high)/2; // 중간 인덱스

            if (target == rotated[mid]) { // 찾았을 때
                return mid;
            }

            if (target >= rotated[row]){ // mid 기준 왼쪽
               high = mid - 1;
            } else { // mid 기준 오른쪽
                row = mid + 1;
            }
        }
        return -1; // 못찾았을 때
    }
}
// 반례가 있어서 좋은 알고리즘이 아님