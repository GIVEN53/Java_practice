import java.util.*;

public class Printer {
    public static void main(String[] args) {
        int bufferSize = 2;
        int capacities = 10;
        int[] documents = new int[]{7, 4, 5 ,6};

        int output = Solution10.queuePrinter(bufferSize, capacities, documents);
        System.out.println(output);
    }
}

/*
인쇄 작업 목록의 크기 : buffersize
최대 용량 : capacities
인쇄할 문서의 크기가 나열된 배열 : documents
모두 인쇄되는데 걸리는 최소 시간을 리턴
 */
class Solution10 {
    public static int queuePrinter(int bufferSize, int capacities, int[] documents) {
        Queue<Integer> doc = new LinkedList<>(); // 문서 큐
        for (int document : documents) {
            doc.add(document);
        }

        Queue<Integer> printer = new LinkedList<>(); // 프린터기에 들어갈 큐
        for (int i = 0; i < bufferSize; i++) { // 작업 목록만큼 빈 목록 초기 세팅
            printer.add(0);
        }
        int sum = 0; // 프린터기 용량
        int second = 0;

        while (printer.size() > 0) { // 출력하면서 초 세기
            int printerOut = printer.poll(); // 프린터에서 출력
            sum -= printerOut; // 용량 업데이트

            // 프린터기 다음 목록 세팅
            if(doc.size() != 0) { //문서 목록이 남아 있을 때
                if (sum + doc.peek() <= capacities) { // 문서목록과 프린터기용량의 합이 총 용량보다 작거나 같을 때
                    int documentOut = doc.poll(); // 문서목록에서 하나 빼기
                    printer.add(documentOut); // 프린터에 문서추가
                    sum += documentOut; // 용량 업데이트
                }
                else {printer.add(0);} // 용량보다 크면 빈 목록 추가
            }
            second++; // 1초 증가
        }
        return second;
    }
}