import java.util.*;

public class MissHouseMeal {
    public static void main(String[] args) {
        String[] dishes = {"eggroll", "kimchi", "fishSoup"};
        Solution26 obj = new Solution26();
        ArrayList<String[]> output = obj.missHouseMeal(dishes);

        for(String[] arr : output) {
            System.out.println(Arrays.toString(arr));
        }
    }
}

// 멱집합
class Solution26 {
    public ArrayList<String[]> missHouseMeal(String[] sideDishes) {
        Arrays.sort(sideDishes);
        Stack<String> stack = new Stack<>();
        ArrayList<String[]> result = new ArrayList<>();

         result = powerset(stack, sideDishes, 0, result);
         result.sort((o1, o2) -> Arrays.toString(o1).compareTo(Arrays.toString(o2)));
         return result;

    }
    ArrayList<String[]> powerset(Stack<String> stack, String[] arr, int k, ArrayList<String[]> result) {
        if (k == arr.length) {
            String[] sArr = stack.toArray(new String[0]);
            result.add(sArr);
            return result;
        }

        stack.push(arr[k]);
        powerset(stack,arr,k+1,result);
        stack.pop();
        powerset(stack, arr,k+1, result);
        return result;
    }
}
/*
0,1,2일 때
powerset(0)

stack.add(0)
powerset(1)

stack.add(1)
powerset(2)

stack.add(2)
powerset(3)
0, 1, 2

stack.pop(2)
powerset(3)
0, 1

stack.pop(1)
powerset(2)

stack.add(2)
powerset(3)
0, 2

stack.pop(2)
powerset(3)
0

stack.pop(0)
powerset(1)

stack.add(1)
powerset(2)

stack.add(2)
powerset(3)
1, 2

stack.pop(2)
powerset(3)
1

stack.pop(1)
powerset(2)

stack.add(2)
powerset(3)
2

stack.pop(2)
powerset(3)
x
 */