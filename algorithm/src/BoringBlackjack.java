import java.util.*;

public class BoringBlackjack {
    public static void main(String[] args) {
        int[] cards = {2, 3, 4, 8, 13};
        Solution24 obj = new Solution24();

        int output = obj.boringBlackjack(cards);
        System.out.println(output);
    }
}

// 조합
class Solution24 {
    public int boringBlackjack(int[] cards) {
        ArrayList<Integer> result = new ArrayList<>();
        int temp[] = new int[3];

        result = combination(0, 3, 0, cards, temp, result);

        return cntPrime(result);
    }

    ArrayList<Integer> combination(int n, int r, int start, int[] cards, int[] temp, ArrayList<Integer> result) {
        if (n == r) {
            return sumList(result, temp);
        }
        for (int i = start; i < cards.length; i++) {
            temp[n] = cards[i];
            int[] outcome = Arrays.copyOf(temp, temp.length);
            result = combination(n+1, r, i+1, cards, outcome, result);
        }
        return  result;

    }

    ArrayList<Integer> sumList(ArrayList<Integer> result, int[] arr) { // 배열의 합을 리스트에 넣는 메서드
        int sum = 0;
        for (int num : arr) {
            sum += num; // 배열 요소의 합
        }
        result.add(sum);
        return result;
    }

    int cntPrime(ArrayList<Integer> result) { // 소수 개수 메서드
        int cnt = 0;
        boolean[] arr = new boolean[result.size()]; // 소수 확인 배열

        int idx = 0;
        while (idx < result.size()) {
            int num = result.get(idx); // 리스트 요소 하나씩 꺼냄
            arr[idx] = true; // 소수 확인 배열의 인덱스를 true로 변경

            for (int i =2; i <= Math.sqrt(num); i++) { // 소수 판단
                if (num%i == 0) {
                    arr[idx] = false; // 소수가 아니면 false
                    break; // 더 볼 필요 없으므로 for문 탈출
                }
            }
            if(arr[idx]) cnt++; // 해당 인덱스가 true면 cnt 1증가
            idx++; // 다음 인덱스
        }
        return cnt;
    }

}
