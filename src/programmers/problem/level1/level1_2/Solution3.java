package programmers.problem.level1.level1_2;

import java.util.Stack;

public class Solution3 {
    public int solution(int[][] board, int[] moves) {
        int result = 0;
        Stack<Integer> stack = new Stack<>();
        for (int move : moves) {
            for (int i = 0; i < board.length; i++) {
                int doll = board[i][move - 1];
                board[i][move - 1] = 0;
                if (doll > 0) {
                    System.out.println(doll);
                    if (stack.size() > 0) {
                        int pop = stack.pop();
                        if (doll == pop) {
                            result++;
                        } else {
                            stack.add(pop);
                            stack.add(doll);
                        }
                    } else {
                        stack.add(doll);
                    }
                    break;
                }
            }
        }
        return result * 2;
    }
}
