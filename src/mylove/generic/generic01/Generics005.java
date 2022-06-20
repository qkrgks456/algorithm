package mylove.generic.generic01;

import java.util.*;

public class Generics005 {
    public static void main(String[] args) {
        Test test1 = new Test(1, "RED", 2);
        Test test2 = new Test(2, "GREEN", 5);
        Test test3 = new Test(3, "BLUE", 3);
        List<Test> list = new ArrayList<>();
        list.add(test1);
        list.add(test2);
        list.add(test3);
        System.out.println("=====================");
        System.out.println("NO      NAME    NUM");
        System.out.println("=====================");
        list.forEach(value -> System.out.println(value.no + "    " + value.name + "      " + value.num));
        System.out.println();
        Set<Test> set = new HashSet<>();
        set.add(test1);
        set.add(test2);
        set.add(test3);
        Set<Test> treeSet = new TreeSet<>();
        treeSet.addAll(set);
        System.out.println(treeSet);
        System.out.println("=====================");
        System.out.println("NO      NAME    NUM");
        System.out.println("=====================");
        treeSet.forEach(value -> System.out.println(value.no + "    " + value.name + "      " + value.num));
        System.out.println();
    }
}

class Test implements Comparable<Test> {
    int no;
    String name;
    int num;

    public Test(int no, String name, int num) {
        this.no = no;
        this.name = name;
        this.num = num;
    }

    @Override
    public int compareTo(Test o) {
        return this.no - o.no;
    }
}
