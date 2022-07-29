import java.util.*;

public class RemoveExtremes {
    public static void main(String[] args) {
        String[] arr = {"where", "is", "the", "longest", "word"};

        String[] output = Solution16.removeExtremes(arr);
        System.out.println(Arrays.toString(output));
    }
}

class Solution16 {
    public static String[] removeExtremes(String[] arr) {
        if (arr.length == 0) return null;

        List<String> list = new ArrayList<>(Arrays.asList(arr)); // 리스트로 변경
        int min = list.get(0).length(); // 최소 길이 0번부터
        int indexMin = 0; // 최소 길이 인덱스

        for (String str : list) { // 하나씩 순회
            if(min >= str.length()) { // 최소 길이보다 작거나 같은 str을 찾은 경우
                min = str.length(); // str 길이로 초기화
                indexMin = list.indexOf(str); // str 인덱스로 초기화
            }
        }
        list.remove(indexMin); // 해당 인덱스 제거

        int indexMax = 0; // 최대 길이 인덱스
        int max = list.get(0).length(); // 최대 길이 0번부터

        for (String str : list) {
            if(max <= str.length()) { // 최대 길이보다 크거나 같은 str을 찾은 경우
                max = str.length(); // str 길이로 초기화
                indexMax = list.indexOf(str); // str 인덱스로 초기화
            }
        }
        list.remove(indexMax); // 해당 인덱스 제거

        return list.toArray(new String[0]);

        /*
        다른 풀이
        if (arr.length == 0) return null;
        int min = arr[0].length();
        int max = arr[0].length();
        int indexMin = 0;
        int indexMax = 0;

        for (int i = 0; i < arr.length; i++) {
            if (arr[i].length() <= min) {
                min = arr[i].length();
                indexMin = i;
            }
            if (arr[i].length() >= max) {
                max = arr[i].length();
                indexMax = i;
            }
        }
        String[] result = new String[arr.length-2];
        int index = 0;
        for (int i = 0; i < arr.length; i++) {
            if (i != indexMax && i != indexMin) {
                result[index] = arr[i];
                index++;
            }
        }
        return result;
        */
    }
}