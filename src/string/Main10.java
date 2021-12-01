package string;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Main10 {
    public static void main(String[] args) throws Exception {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        String str = bufferedReader.readLine();
        String[] strings = str.split(" ");
        ArrayList<Integer> list = new ArrayList<>();
        ArrayList<Integer> check = new ArrayList<>();
        char[] chars = strings[0].toCharArray();
        char ch = strings[1].charAt(0);
        for (int i = 0; i < chars.length; i++) {
            if (chars[i] == ch) {
                list.add(0);
            } else {
                check.clear();
                for (int j = 0; j < chars.length; j++) {
                    if (chars[j] == ch) {
                        check.add(Math.abs(i - j));
                    }
                }
                int num = check.get(0);
                for (int k = 0; k < check.size(); k++) {
                    if (num > check.get(k)) {
                        num = check.get(k);
                    }
                }
                list.add(num);
            }
        }
        for (int num : list) {
            System.out.print(num + " ");
        }
    }
}
