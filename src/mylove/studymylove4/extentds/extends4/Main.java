package mylove.studymylove4.extentds.extends4;

public class Main {
    public static void main(String[] args) {
        Father father = new Father();
        father.three();
        father.two(); // Grand 부모 two()
        father.one(); // Grand 부모 two() 호출
        Uncle uncle = new Uncle();
        uncle.four();
        uncle.two();
        uncle.one();
        Aunt aunt = new Aunt();
        System.out.println(aunt.toString());
        System.out.println(aunt);
    }
}
