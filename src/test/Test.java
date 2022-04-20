package test;

import java.util.ArrayList;
import java.util.List;

public class Test {
    public static void main(String[] args) {
        List<Integer> oldList = new ArrayList<>();
        oldList.add(0);
        oldList.add(0);
        oldList = test(oldList);
        System.out.println(oldList);

    }

    public static List<Integer> test(List<Integer> list) {
        List<Integer> newList = new ArrayList<>();
        newList.add(3);
        newList.add(5);
        return newList;
    }
}
