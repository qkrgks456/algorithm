package programmers.problem.level1.level1_5;

import java.util.Arrays;
import java.util.Collections;

public class Solution6 {
    public String solution(String s) {
        char[] chars = s.toCharArray();
        Byte[] bytes = new Byte[chars.length];
        for (int i = 0; i < chars.length; i++) {
            bytes[i] = (byte) chars[i];
        }
        Arrays.sort(bytes, Collections.reverseOrder());
        for (int i = 0; i < bytes.length; i++) {
            chars[i] = (char) bytes[i].byteValue();
        }
        return String.valueOf(chars);
    }
}
