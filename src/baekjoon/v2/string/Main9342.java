package baekjoon.v2.string;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main9342 {
    // 와 미친 그냥 정규표현식으로 풀 수 있었다.. 그럼 코드가 한줄이 된다
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        for (int i = 0; i < n; i++) {
            String s = br.readLine();
            String[] strings = s.split("");
            int check = 1;
            boolean flag = true;
            String first = strings[0];
            if (!(first.equals("A") || first.equals("B") || first.equals("C")
                    || first.equals("D") || first.equals("E") || first.equals("F"))) {
                System.out.println("Good");
                continue;
            }
            if (first.equals("A")) {
                check = 2;
            }
            for (int j = 1; j < s.length(); j++) {
                if (check == 1) {
                    if (strings[j].equals("A")) {
                        check++;
                    } else {
                        flag = false;
                        break;
                    }
                }
                if (check == 2) {
                    if (strings[j].equals("F")) {
                        check++;
                    } else if (strings[j].equals("A")) {
                        continue;
                    } else {
                        flag = false;
                        break;
                    }
                }
                if (check == 3) {
                    if (strings[j].equals("C")) {
                        check++;
                    } else if (strings[j].equals("F")) {
                        continue;
                    } else {
                        flag = false;
                        break;
                    }
                }
                if (check == 4) {
                    if (strings[j].equals("C")) {
                        continue;
                    } else if (strings[j].equals("A") || strings[j].equals("B") || strings[j].equals("C")
                            || strings[j].equals("D") || strings[j].equals("E") || strings[j].equals("F")) {
                        check++;
                        continue;
                    } else {
                        flag = false;
                        break;
                    }
                }
                if (check == 5) flag = false;
            }
            if ((check == 4 || check == 5) && flag) {
                System.out.println("Infected!");
            } else {
                System.out.println("Good");
            }

        }

    }
}
