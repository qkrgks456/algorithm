package mylove.generic.generic01;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Generics002 {
    public static void main(String[] args) {
        List<GUserInfo> list = new ArrayList<>();
        list.add(new GUserInfo("아이언맨", 50));
        list.add(new GUserInfo("헐크", 40));
        list.add(new GUserInfo("캡틴", 120));
        int sum = 0;
        Iterator<GUserInfo> iter = list.iterator();
        while (iter.hasNext()) {
            sum += iter.next().age;
        }
        System.out.println(sum / 3);
    }
}

class GUserInfo {
    public String name;
    public int age;

    public GUserInfo(String name, int age) {
        this.name = name;
        this.age = age;
    }
}
