package inflearn.stackqueue;

import java.util.Scanner;
import java.util.Stack;

public class Main01 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String str = scanner.next();
        char[] chars = str.toCharArray();
        Stack<Character> stack = new Stack<>();
        stack.push(chars[0]);
        if (stack.get(0) != ')') {
            for (int i = 1; i < chars.length; i++) {
                stack.push(chars[i]);
                if (stack.contains(')')) {
                    stack.pop();
                    if (stack.size() - 1 >= 0) {
                        stack.remove(stack.size() - 1);
                    } else {
                        stack.push(chars[i]);
                        if(stack.size() ==1){
                            break;
                        }
                    }
                }
            }
            if (stack.size() == 0) {
                System.out.println("YES");
            } else {
                System.out.println("NO");
            }
        } else {
            System.out.println("NO");
        }
    }
}
