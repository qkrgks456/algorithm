package mylove.hashmap1.hashmap09;

import java.util.HashMap;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        Map<String, String> phoneBook = new HashMap();
        Map<String, Map<String, String>> group = new HashMap();
        Object[][] data = new Object[][]{
                {"FRIENS", "first", "010-111-1111"},
                {"FRIENS", "second", "010-222-2222"},
                {"FRIENS", "third", "010-333-3333"},
                {"COMPANY", "red", "010-444-4444"},
                {"COMPANY", "green", "010-555-5555"},
                {"COMPANY", "blue", "010-666-6666"},
                {"FAMILY", "sally", "010-777-7777"},
                {"FAMILY", "alpha", "010-888-8888"}
        };
        for (int i = 0; i < data.length; i++) {
            if (group.get((String) data[i][0]) == null) {
                phoneBook = new HashMap();
                phoneBook.put((String) data[i][2], (String) data[i][1]);
                group.put((String) data[i][0], phoneBook);
            } else {
                group.get((String) data[i][0]).put((String) data[i][2], (String) data[i][1]);
            }
        }

        group.forEach((key, value) -> {
            System.out.println("=======================");
            System.out.println(key + "[" + value.size() + "]");
            System.out.println("=======================");
            value.forEach((key2, value2) -> System.out.println(key2 + "     " + value2));
            System.out.println();
        });
    }
}
