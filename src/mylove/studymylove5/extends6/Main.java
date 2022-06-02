package mylove.studymylove5.extends6;

public class Main {
    public static void main(String[] args) {
        Child22 child22 = new Child22();
        Parent22 parent22 = new Parent22();
        parent22.method1();
        parent22.method2(); // 오버라이딩 해도 부모 객체화를 통했기 때문에 부모 메서드 호출
        // 다형성으로 Parent22 parent22 =new Child22(); 이렇게 하거나 자식 객체를 이용해야한다
        // parent22.method3(); 옵션에 따르면 부모가 method3가 없어서 호출 못합니다 문제 오류인지 확인 부탁드립니다.
    }
}
