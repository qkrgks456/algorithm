package mylove.poly.polystudy;

public class Main {
    public static void main(String[] args) {
        // 업캐스팅은 신경쓰지마라 그냥 부모에 자식들어가는건 아무 문제없음
        Mother mother = new Son1();
        Mother mother2 = new Son2();
        // 다운 캐스팅 주의
        // 아랫줄이 핵심 mother2에는 분명히 Son2객체가 담겨있는데 Son1으로 들어가려고 한다면 당연히 안됨
        // 마치 int에 String을 넣는꼴 그래서 객체를 확인하는 작업을 공부하게 됩니당.
        // Son1 son1 = (Son1) mother2;

        if (mother2 instanceof Son1) {
            Son1 son1 = (Son1) mother2;
        } else if(mother2 instanceof Son2) {
            Son2 son1 = (Son2) mother2;
        }

    }
}
