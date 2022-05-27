package mylove.studymylove2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CallByReference {
    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] ints = {4, 3, 2, 1};

        System.out.println(Arrays.toString(solution.solution(ints)));
    }


}

class Solution {
    public int[] solution(int[] arr) {
        if (arr.length == 1) {
            int[] ints = {-1};
            return ints;
        }
        List<Integer> list = new ArrayList<>();
        int min = Integer.MAX_VALUE;
        int index = 0;
        for (int i = 0; i < arr.length; i++) {
            if (min > arr[i]) {
                min = arr[i];
                index = i;
            }
            list.add(arr[i]);
        }
        list.remove(index);
        int[] answer = new int[arr.length - 1];
        for (int i = 0; i < answer.length; i++) {
            // 0 1 2
            answer[i] = list.get(i);
        }
        return answer;
    }
}