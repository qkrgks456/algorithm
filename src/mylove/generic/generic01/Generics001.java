package mylove.generic.generic01;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Generics001 {
    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>();
        list.add(10);
        list.add(20);
        list.add(30);
        int sum = 0;
        Iterator<Integer> iter = list.iterator();
        while (iter.hasNext()) {
            sum += iter.next();
        }
        System.out.println(sum / 3);
    }
}
