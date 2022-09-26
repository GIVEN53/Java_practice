import java.util.Arrays;

public class GetItemFromTwoSortedArrays {
    public static void main(String[] args) {
        int[] arr1 = new int[]{1, 4, 8, 10};
        int[] arr2 = new int[]{2, 3, 5, 9};

        int output = Solution55.getItemFromTwoSortedArrays(arr1, arr2, 6);
        System.out.println(output);
    }
}

// 길이가 m, n이고 오름차순으로 정렬되어 있는 자연수 배열들을 입력받아 전체 요소 중 k번째 요소를 리턴
class Solution55 {
    public static int getItemFromTwoSortedArrays(int[] arr1, int[] arr2, int k) {
        int[] addArr = new int[arr1.length + arr2.length];
        System.arraycopy(arr1, 0, addArr, 0, arr1.length);
        System.arraycopy(arr2, 0, addArr, arr1.length, arr2.length);
        Arrays.sort(addArr);

        return addArr[k - 1];
    }
}
