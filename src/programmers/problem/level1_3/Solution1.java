package programmers.problem.level1_3;

import java.util.stream.IntStream;

public class Solution1 {
    public static int solution(String dartResult) {
        int[] ints = new int[3];
        String[] strings = dartResult.split("");
        int num = -1;
        for (int i = 0; i < strings.length; i++) {
            if (isNumeric(strings[i])) {
                num++;
                if (strings[i].equals("1")) {
                    if (i != strings.length - 1 && isNumeric(strings[i + 1]) && strings[i + 1].equals("0")) {
                        ints[num] = 10;
                        i++;
                    } else {
                        ints[num] = 1;
                    }
                } else {
                    ints[num] = Integer.parseInt(strings[i]);
                }
            } else {
                switch (strings[i]) {
                    case "D":
                        ints[num] = (int) Math.pow(ints[num], 2);
                        break;
                    case "T":
                        ints[num] = (int) Math.pow(ints[num], 3);
                        break;
                    case "*":
                        if (num == 0) {
                            ints[num] *= 2;
                        } else {
                            ints[num] *= 2;
                            ints[num + 1] *= 2;
                        }
                        break;
                    case "#":
                        ints[num] *= -1;
                        break;
                }
            }
        }
        return IntStream.of(ints).sum();
    }

    public static boolean isNumeric(String s) {
        return s != null && s.matches("[-+]?\\d*\\.?\\d+");
    }
}
