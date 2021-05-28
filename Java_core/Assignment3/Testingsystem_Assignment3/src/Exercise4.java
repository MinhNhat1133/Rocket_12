import java.util.Scanner;

public class Exercise4 {
	public static void main(String[] args) {
		// Q1();
		// Q2();
		// Q3();
		// Q4();
		// Q6();
		// Q7();
        // Q8(); //Q9
//		Q10();
//		Q11();
		
	}

	// ========== Question 1 =========//
	// Nhập một xâu kí tự, đếm số lượng các từ trong xâu kí tự đó (các từ có
	// thể cách nhau bằng nhiều khoảng trắng );
	public static void Q1() {
		Scanner scanner = new Scanner(System.in);
		System.out.println("Hay nhap vao mot chuoi ki tu bat ki : ");
		String a = scanner.nextLine();
		System.out.println("So ki tu cua chuoi ban vua nhap la: " + a.length());
		scanner.close();
	}

	// =========== Question 2 ========//
	// Nhập hai xâu kí tự s1, s2 nối xâu kí tự s2 vào sau xâu s1;
	public static void Q2() {
		Scanner scanner = new Scanner(System.in);
		System.out.println("hay nhap 2 xau ki tu");
		System.out.println("Nhap vao chuoi ki tu thu nhat: ");
		String s1 = scanner.nextLine();
		System.out.println("Nhap vao chuoi ki tu thu hai: ");
		String s2 = scanner.nextLine();
		System.out.println("Khi noi hai chuoi lai ta duoc: " + s1 + " " + s2);
		// C2 syso(s1.concat(s2));
		scanner.close();
	}

	// ========== Question 3 ==========//
	// Viết chương trình để người dùng nhập vào tên và kiểm tra, nếu tên chư
	// viết hoa chữ cái đầu thì viết hoa lên
	public static void Q3() {
		Scanner scanner = new Scanner(System.in);
		String name;

		System.out.println("Nhap Ten: ");
		name = scanner.nextLine();
		// select chu cai dau cua ten (Subtring0,1) va viet hoa no len
		// .toUpperCase().
		String firstCharacter = name.substring(0, 1).toUpperCase();
		// Lenh nay giup ta select cac chu chon lai ngoai tru chu cai dau.
		String leftCharacter = name.substring(1);
		name = firstCharacter + leftCharacter;
		System.out.println(name);

		scanner.close();
	}

	// ======= Question4 =======//
	// Viết chương trình để người dùng nhập vào tên in từng ký tự trong tên
	// của người dùng ra
	public static void Q4() {
		Scanner scanner = new Scanner(System.in);
		System.out.println("Nhap vao ten cua ban: ");
		String name = scanner.nextLine();
		name.toUpperCase();
		for (int i = 0; i < name.length(); i++) {
			System.out.println("Ky tu thu " + (i + 1) + " la: " + name.toUpperCase().charAt(i));
		}
		scanner.close();
	}

	// ========= Question5 ==========//
	// Viết chương trình để người dùng nhập vào họ, sau đó yêu cầu người
	// dùng nhập vào tên và hệ thống sẽ in ra họ và tên đầy đủ
	public static void Q5() {
		Scanner scanner = new Scanner(System.in);
		System.out.println("Nhap ho cua ban: ");
		String ho = scanner.next();
		System.out.println("Nhap Ten cua ban: ");
		String ten = scanner.next();
		System.out.println("Ho ten cua ban la: " + ho.concat(ten));
		scanner.close();
	}

	// ========== Question6 ==========//
	// Viết chương trình yêu cầu người dùng nhập vào họ và tên đầy đủ và
	// sau đó hệ thống sẽ tách ra họ, tên , tên đệm
	public static void Q6() {
		String tendem = "";
		Scanner scanner = new Scanner(System.in);

		System.out.println("Nhập họ tên đầy đủ:");
		String hoten = scanner.nextLine();

		hoten = hoten.trim();

		String[] arg = hoten.split("\\ ");

		String ho = arg[0];
		String ten = arg[arg.length - 1];
		for (int i = 1; i < arg.length - 1; i++) {
			tendem += arg[i] + " ";
		}

		System.out.println("Ho là: " + ho);
		System.out.println("Ten đệm là: " + tendem);
		System.out.println("Ten là: " + ten);
		scanner.close();
	}

	// ============= Question7 ===========//
	// Viết chương trình yêu cầu người dùng nhập vào họ và tên đầy đủ và
	// chuẩn hóa họ và tên của họ
	public static void Q7() {
		Scanner scanner = new Scanner(System.in);
		String hoten;

		System.out.println("Nhap vao ho ten cua ban: ");
		hoten = scanner.nextLine();

		scanner.close();

		// remove space characters
		hoten = hoten.trim();
		/*
		 * dau tien ta viet thuong het ta ca cac chu trong ten neu khong thuc
		 * hien buoc nay viec chuan hoa se khong dc
		 */
		hoten = hoten.toLowerCase();
		/*
		 * rePlace la thay the 1 phan tu nao do bang 1 phan tu khac trong truong
		 * hop khi giua 2 tu co qua nhieu giau cach ta se thay bang chi 1 dau
		 * cach duy nhat
		 */
		hoten = hoten.replaceAll("\\s+", " ");
		String[] words = hoten.split(" ");
		hoten = "";

		for (String word : words) {
			String firstCharacter = word.substring(0, 1).toUpperCase();
			String leftCharacter = word.substring(1);
			word = firstCharacter + leftCharacter;

			hoten += word + " ";
		}

		System.out.println("sau khi chuan hoa: " + hoten);
	}

	// =========== Question 8,9 ==========//
	// Q8: In ra tất cả các group có chứa chữ "Java"
	// Q9 : In ra tất cả các group "Java"
	public static void Q8() {
		String[] groupNames = { "Java co ban", "Javan nang cao", "C++ co ban" };
		for (String groupName : groupNames) {
			// trong Q9 chi can thay contains("java") bang equals ("Java")
			if (groupName.contains("Java")) {
				System.out.println(groupName);
			}
		}

	}
	
	//============ QUextion10 ===========//
	public static void Q10(){
		Scanner scanner = new Scanner(System.in);
		String s1, s2, reverseS1 = "";

		System.out.println("Nhap chuoi ki tu 1 ");
		s1 = scanner.nextLine();

		System.out.println("Nhap chuoi ki tu 2 ");
		s2 = scanner.nextLine();

		scanner.close();

		for (int i = s1.length() - 1; i >= 0; i--) {
			reverseS1 += s1.substring(i, i + 1);
		}

		if (s2.equals(reverseS1)) {
			System.out.println("Đây là chuỗi đảo ngược !");
		}
	}
	// =========== Question11 ===========//
	public static void Q11() {
	    String chuoi;
	    char kyTu = 'a';
	    int count = 0;
	    Scanner scanner = new Scanner(System.in);
	         
	    System.out.println("Nhập vào chuỗi bất kỳ: ");
	    chuoi = scanner.nextLine();
	         
	    // duyệt từ đầu đến cuối chuỗi
	    for (int i = 0; i < chuoi.length(); i++) {
	        // Nếu ký tự tại vị trí thứ i bằng 'a' thì tăng count lên 1
	        if (chuoi.charAt(i) == kyTu) {
	            count++;
	        }
	    }
	         
	    System.out.println("Số lần xuất hiện của ký tự " + kyTu +
	        " trong chuỗi " + chuoi + " = " + count);
	}


}
