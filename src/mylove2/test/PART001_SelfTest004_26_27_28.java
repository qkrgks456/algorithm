package mylove2.test;

import java.util.*;

/***
 * @author CAT~sally (4WK)
1. 콜렉션프레임워크의 종류 (필기)
List   :    순서 [] , 중복허용 []
=>  사용가능메서드: [추가][삭제][갯수][데이터꺼내기]
Set    :    순서 [] , 중복허용 []
=>  사용가능메서드: [추가][삭제][갯수][데이터꺼내기]
Map    :    순서가아닌 [ , ]의 쌍(ENTRY)으로 이루어짐
=>  사용가능메서드: [추가][삭제][갯수][데이터꺼내기]
============================================================
//[SELFTEST026]  ArrayList
 * 	 dto 를 이용하여 ArrayList + Iterator  이용해서 만들기
//[SELFTEST027]  HashSet
 *   dto 를 이용하여 HashSet   + Iterator  이용해서 만들기
//[SELFTEST028]  HashMap
 *   dto 를 이용하여 HashMap   + Iterator  이용해서 만들기

ㅁ 출력된결과
======================
NO	NAME	PRICE
======================
1	white	1000
2	choco	1200
3	banana	1300
 ***/
public class PART001_SelfTest004_26_27_28 {

    public static void main(String[] args) {
        List<TestDto> testDtoList = new ArrayList<>();
        testDtoList.add(new TestDto(1, "white", 1000));
        testDtoList.add(new TestDto(2, "choco", 1200));
        testDtoList.add(new TestDto(3, "banana", 1300));
        print();
        for (TestDto testDto : testDtoList) {
            System.out.println(testDto.getNo() + "   " + testDto.getName() + "    " + testDto.getPrice());
        }
        Set<TestDto> testDtoSet = new HashSet<>();
        testDtoSet.addAll(testDtoList);
        print();
        for (TestDto testDto : testDtoSet) {
            System.out.println(testDto.getNo() + "   " + testDto.getName() + "    " + testDto.getPrice());
        }
        Map<Integer, TestDto> map = new HashMap<>();
        map.put(1, new TestDto(1, "white", 1000));
        map.put(2, new TestDto(2, "choco", 1200));
        map.put(3, new TestDto(3, "banana", 1300));
        print();
        for (Integer key : map.keySet()) {
            TestDto testDto = map.get(key);
            System.out.println(testDto.getNo() + "   " + testDto.getName() + "    " + testDto.getPrice());
        }
    }

    public static void print() {
        System.out.println("======================");
        System.out.println("NO     NAME      PRICE");
        System.out.println("======================");
    }

}

class TestDto {
    private int no;
    private String name;
    private int price;

    public TestDto(int no, String name, int price) {
        this.no = no;
        this.name = name;
        this.price = price;
    }

    public int getNo() {
        return no;
    }

    public void setNo(int no) {
        this.no = no;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }
}