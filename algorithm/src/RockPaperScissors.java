import java.util.*;

public class RockPaperScissors {
    public static void main(String[] args) {
        Solution22 obj = new Solution22();
        ArrayList<String[]> output = obj.rockPaperScissors(5);

        for (String[] arr : output) {
            System.out.println(Arrays.toString(arr));
        }
    }
}

// 중복 순열
class Solution22 {
    public ArrayList<String[]> rockPaperScissors(int rounds) {
        ArrayList<String[]> result = new ArrayList<>();
        String[] arr = new String[rounds]; // {null, null, ...}
        return permutation(0, rounds, arr, result);

    }

    ArrayList<String[]> permutation(int n, int r, String[] arr, ArrayList<String[]> result) {
        if (n == r) {
            result.add(arr);
            return result;
        }

        String[] rps = {"rock", "paper", "scissors"}; // 가위바위보

        for (int i = 0; i < rps.length; i++) { // 3Pn
            arr[n] = rps[i];
            String[] outcome = Arrays.copyOf(arr, arr.length); // arr를 바로 넣으면 같은 주소값이기 때문에 result내의 arr도 동기화됨
            result = permutation(n+1, r, outcome, result);
        }
        return result;

    }
}

