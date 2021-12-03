package inflearn.stackqueue;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main03 {
    public static void main(String[] args) throws Exception {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int num1 = Integer.parseInt(bufferedReader.readLine());
        int[][] ints = new int[num1][num1];
        for (int i = 0; i < num1; i++) {
            String str = bufferedReader.readLine();
            String[] strings = str.split(" ");
            for (int j = 0; j < num1; j++) {
                ints[i][j] = Integer.parseInt(strings[j]);
            }
        }
        int num2 = Integer.parseInt(bufferedReader.readLine());
        String str2 = bufferedReader.readLine();
        String[] strings2 = str2.split(" ");
        int[] ints1 = new int[num2];
        Stack<Integer> stack = new Stack<>();
        int num = 0;
        int result = 0;

        for (int i = 0; i < ints1.length; i++) {
            boolean check = true;
            ints1[i] = Integer.parseInt(strings2[i]) - 1;
            for (int k = 0; k < ints.length; k++) {
                if (ints1[i] == 0) {
                }
                if (ints[k][ints1[i]] > 0) {
                    stack.push(ints[k][ints1[i]]);
                    ints[k][ints1[i]] = 0;
                    check = false;
                    break;
                }
            }
            if (check) {
                stack.push(0);
            }
            if (num == stack.lastElement()) {
                num = stack.pop();
                result++;
                if (num == stack.lastElement()) {
                    stack.pop();
                    result++;
                }
            }
            num = stack.lastElement();
        }
        System.out.println(result);
    }
}

