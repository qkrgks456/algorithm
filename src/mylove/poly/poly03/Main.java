package mylove.poly.poly03;

public class Main {
    public static void main(String[] args) {
        ///////////////////////////
        System.out.println(":::: 1 ) TEST");
        Mother mo = new Mother();
        System.out.println("mo.ma : " + mo.ma);
        System.out.println("mo.mb : " + mo.mb);
        mo.func();

        ///////////////////////////
        System.out.println(":::: 2 ) TEST");
        Daugther da = new Daugther();
        System.out.println("da.ma : " + da.ma);
        System.out.println("da.mb : " + da.mb);
        System.out.println("da.mc : " + da.mc);
        da.func();

        mo = new Daugther();// 업캐스팅이 된 놈이 와야함
        da = (Daugther) mo; // 그래야 다운캐스팅 문제 안 생김
        System.out.println(da);
        ///////////////////////////
        System.out.println(":::: 3 ) TEST");
        Mother md = new Daugther();
        System.out.println("md.ma : " + md.ma);
        System.out.println("md.mb : " + md.mb);
        System.out.println("md.mc : " + ((Daugther) md).mc); // 여기 오류 md를 다운캐스팅해서 찾아주자
        md.func();


        System.out.println(":::: 4 ) TEST");
        System.out.println((float) 10);
        // Daugther dm = (Daugther) new Mother(); // 여기 오류남 업 캐스팅이 된 녀석을 이용하자
        Daugther dm = (Daugther) md;

        System.out.println(":::: 5 ) TEST");
        Mother md2 = da;
        System.out.println("md2.ma : " + md2.ma);
        System.out.println("md2.mb : " + md2.mb);
        System.out.println("md2.mc : " + ((Daugther) md2).mc);// 여기 오류 md를 다운캐스팅해서 찾아주자
        md2.func();

    }
}
