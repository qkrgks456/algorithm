import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main2 {

    public static void main(String[] args) {
        List<Integer> list2 = new ArrayList<>(Arrays.asList(3));
        List<Integer> list3 = new ArrayList<>(Arrays.asList(1));
        List<List<Integer>> list = new ArrayList<>();
        list.add(list2);
        list.add(list3);
        List<Integer> list4 = new ArrayList<>(Arrays.asList(1, 2));

        for (int i = 0; i < list.size(); i++) {
            System.out.println(list4.containsAll(list.get(i)));
        }


    }
}
