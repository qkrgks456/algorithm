package baekjoon.etc4;

public class Test {
    public static void main(String[] args) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(56);
        stringBuilder.append(78);
        stringBuilder.append(99);
        stringBuilder.delete(0, stringBuilder.length());
        System.out.println(stringBuilder);
    }
}
