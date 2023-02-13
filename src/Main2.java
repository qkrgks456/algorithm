import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Main2 {

    public static void main(String[] args) {
        Map<String, Integer> map = new HashMap<>();
        for (int i = 'a'; i <= 'z'; i++) {
            map.put(String.valueOf((char) i), -1);
        }
        String[] strings = "foobar".split("");
        int[] result = new int[strings.length];
        for (int i = 0; i < strings.length; i++) {
            if (map.get(strings[i]) == -1) {
                result[i] = -1;
                map.put(strings[i], i);
                continue;
            }
            result[i] = i - map.get(strings[i]);
            map.put(strings[i], i);
        }
    }
}
