import java.util.*;

public class NewChickenRecipe {
    public static void main(String[] args) {
        int[] arr = {11, 1, 10, 1111111111, 10000};
        Solution23 obj = new Solution23();
        ArrayList<Integer[]> output = obj.newChickenRecipe(arr, 4);

        for (Integer[] stuff : output) {
            System.out.println(Arrays.toString(stuff));
        }

    }
}

// 순열
class Solution23 {
    public ArrayList<Integer[]> newChickenRecipe(int[] stuffArr, int choiceNum) {
        ArrayList<Integer> freshArr = new ArrayList<>(); // 상하지 않은 것만 담을 리스트
        for (int num : stuffArr) { // 재료 순회
            int cnt = 0;
            String stuff = String.valueOf(num); // 선택한 재료 String으로 변환
            for (int i = 0; i < stuff.length(); i++) { // 선택한 재료 순회
                if (stuff.charAt(i) == '0') { // 0이 있으면 cnt 1증가
                    cnt++;
                }
            }
            if (cnt < 3) { // 상하지 않은 것은 리스트에 담음
                freshArr.add(Integer.valueOf(stuff));
            }
        }
        if (freshArr.size() == 0 || freshArr.size() < choiceNum) return null; // 쓸 재료가 없거나, choiceNum보다 작으면 null
        freshArr.sort(null);

        ArrayList<Integer[]> result = new ArrayList<>();
        boolean[] visited = new boolean[freshArr.size()]; // 지나갔는지 확인할 배열

        return permutation(0, choiceNum, new Integer[choiceNum], visited, result, freshArr);
    }
    ArrayList<Integer[]> permutation(int n, int r, Integer[] arr, boolean[] visited, ArrayList<Integer[]> result, ArrayList<Integer> freshArr) {
        if (n == r) {
            result.add(arr);
            return result;
        }

        for (int i = 0; i < freshArr.size(); i++) {
            if (!visited[i]) {
                visited[i] = true;
                arr[n] = freshArr.get(i);
                Integer[] outcome = Arrays.copyOf(arr, arr.length);
                result = permutation(n+1, r, outcome, visited, result, freshArr);
                visited[i] = false;
            }
        }
        return result;
    }
}
