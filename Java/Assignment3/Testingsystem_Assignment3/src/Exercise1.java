import java.util.Random;
import java.util.Scanner;

public class Exercise1 {
	public static void main(String[] args) {
//		Q1();
//		Q2();
//		Q3();
		Q4();


	}
	//======= Question1 ========//
	// Khai báo 2 số lương có kiểu dữ liệu là float.
	// Khởi tạo Lương của Account 1 là 5240.5 $
	// Khởi tạo Lương của Account 2 là 10970.055$
	// khai bao nhu sau :
	// float Salary1;
	// float Salary2;
	// Salary1 = (float) 5240.5;
	// Salary2 = (float) 10970.055; ( cung co the lam nhu ben duoi)
	// Khai báo 1 số int để làm tròn Lương của Account 1 và in số int đó ra
	// Khai báo 1 số int để làm tròn Lương của Account 2 và in số int đó ra
	public static void Q1() {
		float luongAccount1 = 5240.5f;
		float luongAccount2 = 10970.055f;
		int luongLamTronAccount1 = (int) luongAccount1;
		System.out.println(luongLamTronAccount1);
		int luongLamTronAccount2 = (int) luongAccount2;
		System.out.println(luongLamTronAccount2);
	}
	
	//========= Question2 =========//
	public static void Q2() {
		int min = 0;
		int max = 99999;
		int a = (int) (Math.random() * max) + min;
		while (a < 10000) {
			a = a * 10;
		}
		System.out.println("SO ngau nhien co 5 chu so: " + a);

	}
	//======== Question 3 ========//
		public static void Q3() {
			int min = 0;
			int max = 99999;
			int a = (int) (Math.random() * max) + min;
			while (a < 10000) {
				a = a * 10;
			}
			System.out.println("SO ngau nhien co 5 chu so: " + a);
			String b = String.valueOf(a);
			System.out.println("Hai so cuoi la: " + b.substring(3));
		}

	// ====== QUestion4 ======//
	public static void Q4() {
		Scanner scanner = new Scanner(System.in);
		System.out.println("Nhap so nguyen a: ");
		int a = scanner.nextInt();
		System.out.println("Nhap vao so nguyen b: ");
		int b = scanner.nextInt();
		if (b == 0) {
			System.out.println("b phai la mot so khac 0");
		}else {
			float c = a / b;
			System.out.println("Ket qua a/b la :  " + c);
		}
		
	}

}
