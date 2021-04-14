import java.util.Scanner;

public class Exercise1 {
	public static void main(String[] args) {
		
	//====== Question1 ======//
	float luongAccount1 = 5240.5f;
	float luongAccount2 =10970.055f;
	int luongLamTronAccount1= (int) luongAccount1;
	System.out.println(luongLamTronAccount1);
	int luongLamTronAccount2 = (int) luongAccount2;
	System.out.println(luongLamTronAccount2);
	
	//====== QUestion2 ======//
	//====== Question4 ======//
	ThuongCuaHaiSo();
	}
	public static void ThuongCuaHaiSo(){
		Scanner scanner = new Scanner(System.in);
		System.out.println("Nhap so nguyen a: ");
		int a = scanner.nextInt();
		System.out.println("Nhap vao so nguyen b: ");
		int b = scanner.nextInt();
		float c = a/b;
		System.out.println("Ket qua a/b la :  " + c );
	}

}
