import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Queue;

public class HeapSort {
    public static void main(String[] args) {
        int[] arr = {4, 10, 3, 5, 1};

        int[] output = Solution52.heapSort(arr);
        System.out.println(Arrays.toString(output));
    }
}

// 배열을 입력받아 오름차순으로 정렬
// 힙 정렬 (최소 힙)
class Solution52 {
    public static int[] heapSort(int[] arr) {
        Queue<Integer> heap = new PriorityQueue<>();
        for (int num : arr) heap.offer(num);

        int i = 0;
        while (heap.size() > 0) {
            arr[i++] = heap.poll();
        }

        return arr;
    }
}
