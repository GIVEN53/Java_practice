import java.util.*;

public class MovingStuff {
    public static void main(String[] args) {
        int[] stuff = {73, 60, 80, 87, 103, 109, 119, 123, 128, 129, 136, 146, 153, 168, 182};

        int output = Solution15.movingStuff(stuff, 200);
        System.out.println(output);
    }
}

class Solution15 {
    public static int movingStuff(int[] stuff, int limit) {
        List<Integer> list = new ArrayList<>();
        for (int e : stuff) {list.add(e);} // 짐 리스트
        list.sort(null); // 무게 오름차순 정렬

        int cnt = 0; // 박스 개수

        while (!list.isEmpty()) {
            int firstStuff = list.remove(0); // 첫 번째 짐 제거
            int maxStuff = 0; // 무게 제한에 가장 근접한 그룹의 최대 값
            cnt++; // 박스 하나 열기

            // 짐이 하나만 남아서 위에서 추출되고 for문으로 조합할 그룹이 없을 때
            if (list.isEmpty()) {
                break;
            }

            // 짐 그룹 찾기
            for (int nextStuff : list) {
                int group = firstStuff + nextStuff; // 짐 그룹

                if (group <= limit && nextStuff > maxStuff) { // 무게 제한이하 그룹이고
                    maxStuff = nextStuff;                     // 최대값보다 클 때
                }
            }

            if (maxStuff > 0) { // 그룹을 찾았을 때
                list.remove(list.indexOf(maxStuff)); // 그룹 된 최대값 객체도 제거
            }
            else {
                list.remove(list.size()-1); // 그룹이 없으면 마지막 인덱스도 삭제
                cnt++;
            }

        }
        return cnt;
    }

// 다른 풀이, 인덱스로 접근
/*
	public static int movingStuff(int[] stuff, int limit) {
        Arrays.sort(stuff);  // 무게 오름차순 정렬

        int lightIdx = 0; // 가장 가벼운 짐의 인덱스
        int heavyIdx = stuff.length - 1; // 가장 무거운 짐의 인덱스
        int twoStuff = 0; // 2개의 짐을 넣을 수 있는 개수

        // 짐 그룹 찾기
        while(lightIdx < heavyIdx) {
            if(stuff[lightIdx] + stuff[heavyIdx] <= limit) { // 제한 이하 그룹일 때
                lightIdx++; // 다음 가벼운 짐
                heavyIdx--; // 다음 무거운 짐
                twoStuff++;
            }
            else { // 그룹이 없을 때
                heavyIdx--; // 다음 무거운 짐
            }
        }
        // 전체 짐의 개수 - 그룹 개수
        return stuff.length - twoStuff; //
    }
 */
}

