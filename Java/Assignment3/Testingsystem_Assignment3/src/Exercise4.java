import java.util.Scanner;

public class Exercise4 {
	public static void main(String[] args) {
//	Q1();
//	Q2();
	Q3();
//	Q4();
	}
	public static void Q1() {
		Scanner scanner = new Scanner(System.in);
		System.out.println("Hay nhap vao mot chuoi ki tu bat ki : ");
		String a = scanner.nextLine();
		System.out.println("So ki tu cua chuoi ban vua nhap la: " + a.length());
	}

	public static void Q2() {
		Scanner scanner = new Scanner(System.in);
		System.out.println("hay nhap 2 xau ki tu");
		System.out.println("Nhap vao xau ki tu thu nhat: ");
		String s1 = scanner.nextLine();
		System.out.println("Nhap vao xau ki tu thu 2: ");
		String s2 = scanner.nextLine();
		System.out.println(s1 + " " + s2);
	}

	public static void Q3() {
		Scanner scanner = new Scanner(System.in);
		String name;

		System.out.println("Nhap Ten: ");
		name = scanner.nextLine();

		String firstCharacter = name.substring(0, 1).toUpperCase();

		String leftCharacter = name.substring(1);

		name = firstCharacter + leftCharacter;

		System.out.println(name);

		scanner.close();
	}
		
	

	public static void Q4() {
		Scanner scanner = new Scanner(System.in);
		System.out.println("Nhap vao ten cua ban: ");
		String name2 = scanner.nextLine();
		name2.toUpperCase();
		for (int i = 0; i < name2.length(); i++) {
			System.out.println("Ky tu thu " + (i + 1) + " la: " + name2.toUpperCase().charAt(i));
		}
	}

	public static void Q5() {
		Scanner scanner = new Scanner(System.in);
		System.out.println("Nhap ho cua ban: ");
		String ho = scanner.next();
		System.out.println("Nhap Ten cua ban: ");
		String ten = scanner.next();
		System.out.println("Ho ten cua ban la: " + ho + " " + ten);
	}
 public static void Q6 (){
		Scanner scanner = new Scanner(System.in);
		System.out.println("Nhap ho ten day du : ");
		String name = scanner.nextLine();
		String[] name1 = name.split("\\ ");
		System.out.println("Ho la : " + name1[0]);
		System.out.print("Ten dem la : ");
		for (int i = 1; i < name1.length - 1; i++) {
			System.out.print(name1[i] + " ");
		}
		System.out.println("\n" + "Ten la : " + name1[name1.length - 1]);
	}

	

	 
	 
 }
 

 
