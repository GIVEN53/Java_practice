import java.util.Arrays;

public class ConvertPhoneNumber {
    public static void main(String[] args) {
        int[] arr = {0, 1, 0, 1, 2, 3, 4, 5, 6, 7, 8}; //scan으로 바꾸기

        String head = "010";
        String body = Arrays.toString(Arrays.copyOfRange(arr, arr.length-8, arr.length-4));
        body = body.replaceAll("\\[", "")
                .replaceAll(",", "")
                .replaceAll(" ", "")
                .replaceAll("]", "");

        String tail = Arrays.toString(Arrays.copyOfRange(arr, arr.length-4, arr.length));
        tail = tail.replaceAll("\\[", "")
                .replaceAll(",", "")
                .replaceAll(" ", "")
                .replaceAll("]", "");

        if (arr.length == 11) {
            head = Arrays.toString(Arrays.copyOfRange(arr, 0, 3));
            head = head.replaceAll("\\[", "")
                    .replaceAll(",", "")
                    .replaceAll(" ", "")
                    .replaceAll("]", "");
        }
        System.out.printf("(%s)%s-%s", head, body, tail);
    }
}