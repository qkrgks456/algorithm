package baekjoon.step.input;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main10 {
    public static void main(String[] args) throws Exception {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        String s = bufferedReader.readLine();
        System.out.println(s += "??!");
    }
}
