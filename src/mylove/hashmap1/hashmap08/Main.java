package mylove.hashmap1.hashmap08;

import java.util.HashMap;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        Map<Student, Integer> map = new HashMap<>();
        map.put(new Student(1, "홍길동"), 95);
        map.put(new Student(1, "홍길동"), 95);
        map.put(new Student(1, "홍길동"), 95);
        map.put(new Student(1, "홍길동"), 95);
        System.out.println("총 Entry 수 : " + map.size());
    }
}
