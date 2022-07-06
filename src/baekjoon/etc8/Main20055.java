package baekjoon.etc8;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main20055 {
    static int[] ints;
    static int result = 0;
    static int[] ch;

    public static void main(String[] args) throws Exception {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());
        int n = Integer.parseInt(stringTokenizer.nextToken());
        int k = Integer.parseInt(stringTokenizer.nextToken());
        int checkNum = n - 1;
        ints = new int[2 * n];
        ch = new int[n];
        stringTokenizer = new StringTokenizer(bufferedReader.readLine());
        for (int i = 0; i < ints.length; i++) {
            ints[i] = Integer.parseInt(stringTokenizer.nextToken());
        }

        while (true) {
            result++;
            // 1.
            // 회전
            rotation();
            for (int i = ch.length - 2; i >= 0; i--) {
                if (ch[i] == 1) {
                    if (i + 1 == checkNum) {
                        ch[i] = 0;
                    } else {
                        ch[i] = 0;
                        ch[i + 1] = 1;
                    }
                }
            }
            // 2.
            for (int i = ch.length - 2; i >= 0; i--) {
                if (ch[i] == 1) {
                    if (i + 1 == checkNum) {
                        if (ints[i + 1] >= 1) {
                            ch[i] = 0;
                            ints[i + 1]--;
                        }
                    } else {
                        if (ch[i + 1] == 0 && ints[i + 1] >= 1) {
                            ch[i] = 0;
                            ch[i + 1] = 1;
                            ints[i + 1]--;
                        }
                    }
                }
            }

            // 3.
            if (ints[0] != 0) {
                ch[0] = 1;
                ints[0]--;
            }

            // 4.
            int count = 0;
            for (int num : ints) {
                if (num == 0) {
                    count++;
                }
            }
            if (count >= k) {
                System.out.println(result);
                break;
            }
        }
    }

    public static void rotation() {
        int num = ints[ints.length - 1];
        for (int i = ints.length - 1; i > 0; i--) {
            ints[i] = ints[i - 1];
        }
        ints[0] = num;
    }
}
