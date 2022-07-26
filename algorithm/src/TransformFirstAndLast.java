import java.util.HashMap;

public class TransformFirstAndLast {
    public static void main(String[] args) {
        String[] arr = new String[]{"Queen", "Elizabeth", "Of Hearts", "Beyonce"};

        HashMap<String, String> output = Solution1.transformFirstAndLast(arr);
        System.out.println(output);
    }
}

// 배열을 입력받아 차례대로 배열의 첫 요소와 마지막 요소를 키와 값으로 하는 HashMap을 리턴
class Solution1 {
    public static HashMap<String, String> transformFirstAndLast(String[] arr) {
        if (arr.length == 0) {
            return null;
        }
        HashMap<String, String> hashMap = new HashMap<>();
        hashMap.put(arr[0],arr[arr.length-1]);

        return hashMap;
    }
}