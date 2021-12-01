package string;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main03 {
    public static void main(String[] args) throws Exception {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        String str = bufferedReader.readLine();
        String[] strings = str.split(" ");
        String result = strings[0];
        for (String str1 : strings) {
            if (result.length() < str1.length()) {
                result = str1;
            }
        }
        System.out.println(result);
    }
}
