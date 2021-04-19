
public class Exercise3 {
	public static void main(String[] args) {
		Q1();
		Q2();
//		Q3();
	}
		public static void Q1(){
		//====== Question1 ======//
		Integer luong = new Integer(5000);
        float a = luong; // unboxing
        System.out.printf("%.2f",a);
		}
		public static void Q2(){
        //======= Question 2 =======//
		String x = "1234567";
      int y = Integer.parseInt(x);
      System.out.println("\n"+y );      
		}
		public static void Q3(){
			Integer a = 1234567;
			int b = a.intValue();
			System.out.println(b);
		}

}

