package baekjoon.etc8;

import java.util.HashMap;
import java.util.Map;

public class Test {
    public static void main(String[] args) throws Exception {
        Map<String, String> map = new HashMap<>();
        map.put("바보", "안녕");
        map.put("바보1", "일");
        map.put("바보2", "이");
        Thread thread = new Thread(() -> {
            try {
                Thread.sleep(500);
            } catch (Exception e) {
                e.printStackTrace();
            }
            map.get("hello");
            map.remove("안녕");
            map.put("안녕", "바보");
            System.out.println(map);
        });

        Thread thread2 = new Thread(() -> {
            try {
                Thread.sleep(500);
            } catch (Exception e) {
                e.printStackTrace();
            }
            map.remove("바보");
            map.put("안녕", "친구");
            System.out.println(map);
        });

        thread2.start();
        thread.start();
    }
}
