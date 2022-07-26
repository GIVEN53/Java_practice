import java.util.HashMap;

public class ConvertListToObject {
    public static void main(String[] args) {
        String[][] arr = {
                {"make", "Porsche"},
                {"model", "Taycan"},
                {"year", "2019"},
                {"price", "$210,000"}
        };
        HashMap<String, String> output = Solution7.convertListToHashMap(arr);
        System.out.println(output);
    }
}

// 2차원 배열을 입력받아 각 배열을 이용해 만든 HashMap을 리턴
class Solution7 {
    public static HashMap<String, String> convertListToHashMap(String[][] arr) {
        HashMap<String, String> hashMap = new HashMap<>();

        for (String[] strings : arr) {
            if (strings.length != 0) {
                if (!hashMap.containsKey(strings[0])) {
                    hashMap.put(strings[0], strings[1]);
                }
            }
        }
        return hashMap;
    }
}
