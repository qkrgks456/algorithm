package mylove2.test;


/***
 * @author CAT~sally (3WK)
 		//[SELFTEST023] class(1) 필요한 자료의 묶음.
 		 1. 메인은 다음과 같다.
 		 	Milk m1 = new Milk("choco" , 1200);
 		 	System.out.println( m1 );  // 출력된 결과 : choco / 1500
 		 	Milk m2 = new Milk();
 		 	System.out.println( m2 );  // 출력된 결과 : white / 1300
 		 	
		 2.	Milk 클래스를 구현하시오 
			  	클래스의 기능 : 데이터를 받아서 전달하는 기능  (DTO)
				1) 멤버변수    private  name이름 ,  private  price가격      
				2) 생성자      기본생성자 : 
						   필드생성자 : 이름,  , 가격을 입력받아 처리해주는 생성자	
				3) 멤버함수  ---		  

		//[SELFTEST024] class(2) 클래스 배열
 		 1. 메인은 다음과 같다.
			Milk []milks = new Milk[3];   
			milks[0] = new Milk("white",1000);
			milks[1] = new Milk("choco",1200);
			milks[2] = new Milk("banana",1500);
			
			MilkPrint  print = new MilkPrint();   
			print.show(  milks     );	
			// 출력된 결과 : 
			 * white  / 1000
			 * choco  / 1200
			 * banana / 1500 
			 
		 2.	MilkPrint 클래스를 구현하시오 
 		 

		//[SELFTEST025] 다형성
		class TestA2{
			int  a = 10;
			public TestA2() { super();  }
			@Override public String toString() { return "TestA2 [a=" + a + "]"; }
		}
		class TestB2 extends  TestA2{ 
			int b=20;
			public TestB2() { super();  }
			@Override public String toString() { return "TestB2 [b=" + b + "]"; }
		}
		public class ExtendsBasic009_2_Polymorphism2_short {
			public static void main(String[] args) {        
				TestA2   ta = new TestA2();    // [ ta   [a]  ]
				TestB2   tb = ta;                   // [ tb   [b]-[a]  ]
				// 오류나는 이유는? 
			}
		 }
 ***/
public class PART001_SelfTest003_23_24_25 {

	public static void main(String[] args) {
	 
	}

}
