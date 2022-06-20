package mylove.generic.generic01;

import java.util.*;

public class Generics004 {
    public static void main(String[] args) {
        System.out.println("\n\n [001] ArrayList");
        List<MilkDto1> list = new ArrayList<>();
        list.add(new MilkDto1(1, "white", 1000));
        list.add(new MilkDto1(2, "choco", 1200));

        System.out.println("\n\n [002] HashSet");
        Set<MilkDto1> set = new HashSet<>();
        set.add(new MilkDto1(1, "white", 1000));
        set.add(new MilkDto1(2, "choco", 1200));

        System.out.println("\n\n [003] HashMap");
        Map<Integer, MilkDto1> map = new HashMap();
        map.put(1, new MilkDto1(1, "white", 1000));
        map.put(2, new MilkDto1(2, "choco", 1200));

        WildPrint<?> print = new WildPrint<List>(list);
        print.show();
        print = new WildPrint<Set>(set);
        print.show();
        print = new WildPrint<Map>(map);
        print.show();
    }
}

class WildPrint<T> {
    T collection;

    public WildPrint(T collection) {
        this.collection = collection;
    }

    public void show() {
        if (collection instanceof List) {
            List<MilkDto1> change = (List<MilkDto1>) collection;
            print();
            for (MilkDto1 milkDto1 : change) {
                System.out.println(milkDto1.getMno() + "         " + milkDto1.getMname() + "          " + milkDto1.getMprice());
            }
            System.out.println();
        } else if (collection instanceof Map) {
            Map<Integer, MilkDto1> map = (Map<Integer, MilkDto1>) collection;
            print();
            map.forEach((key, value) -> {
                System.out.println(value.getMno() + "         " + value.getMname() + "          " + value.getMprice());
            });
            System.out.println();
        } else {
            Set<MilkDto1> set = (Set<MilkDto1>) collection;
            print();
            for (MilkDto1 milkDto1 : set) {
                System.out.println(milkDto1.getMno() + "         " + milkDto1.getMname() + "          " + milkDto1.getMprice());
            }
            System.out.println();
        }
    }

    public void print() {
        System.out.println("===========================");
        System.out.println("NO      NAME        PRICE");
        System.out.println("===========================");
    }
}


class MilkDto1 {
    private int mno;
    private String mname;
    private int mprice;

    public MilkDto1(int mno, String mname, int mprice) {
        this.mno = mno;
        this.mname = mname;
        this.mprice = mprice;
    }

    public int getMno() {
        return mno;
    }

    public void setMno(int mno) {
        this.mno = mno;
    }

    public String getMname() {
        return mname;
    }

    public void setMname(String mname) {
        this.mname = mname;
    }

    public int getMprice() {
        return mprice;
    }

    public void setMprice(int mprice) {
        this.mprice = mprice;
    }
}
