package program;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
//import java.text.ParseException;
//import java.text.SimpleDateFormat;
//import java.util.Date;
import java.util.Scanner;

public class Exercise_5_Input_from_console {
	public static void main(String[] args) throws ParseException {
		Scanner scanner = new Scanner(System.in);

		// Question1:
		// System.out.println("Nhap vao 3 so nguyen bat ki: ");
		// for (int i = 0; i < 3; i++) {
		// int x = scanner.nextInt();
		// System.out.println("Ban da nhap: " + x + "\n");
		// };

		// QUestion2:????

		// Question3:
		System.out.println("NHap vao ho: ");
		String Ho = scanner.nextLine();
		System.out.println("Nhap vao ten: ");
		String Ten = scanner.nextLine();
		System.out.println("Ho Ten cua ban la : " + Ho + " " + Ten);

		// Question 4:
		System.out.println("hay nhap ngay sinh cua ban (Dinh dang yyyy/MM/dd): ");
		String dateInput = scanner.next();
		String pattern = "yyyy/MM/dd";
		SimpleDateFormat dateFormat = new SimpleDateFormat(pattern);
		Date birtday = dateFormat.parse(dateInput);
		System.out.println("Ngay sinh cua ban vua nhap la: " + birtday);
		
		//Question5:
		createAccount(); //sau khi tao method ben ngoai co the goi no tu day gan giong voi Select trong mysql.
		
		//QUestion6:
		CreatDepartment();
		
		//Question7:
		System.out.println("Hay nhap vao mot so chan : ");
		int soChan = scanner.nextInt();
		if (soChan % 2==0){
			System.out.println("So chan ban vua nhap la: "+ soChan);
		}else{
			System.out.println("Day khong phai so chan");
		}
		
		//Question8:
		System.out.println("Nhap vao chuc nang muon su dung (1:Tao account , 2:Tao Department): ");
		int chucNang = scanner.nextInt();
		switch (chucNang){
		case 1:
			createAccount();       //Dan minh den method createAcocunt.
			break;					
		case 2:
			CreatDepartment();
			break;
		default:
			System.out.println("Chi Nhap 1 hoac 2 de chon chuc nang ban muon thuc hien");
		}
		//Question9: ???

	}
			
	// Question5:
	public static void createAccount() throws ParseException {

		Scanner scanner = new Scanner(System.in);
		System.out.println("Nhap Account ID: ");
		int accountID = scanner.nextInt();
		System.out.println("Nhap vao Email: ");
		String email = scanner.next();
		System.out.println("Nhap vao department ID: ");
		int departmentid = scanner.nextInt();

		System.out.println("Nhap vao postionId(1->5): ");
		int positionId = scanner.nextInt(6);
		switch (positionId) {						
		case 1:
			System.out.println("position.Dev");
			break;
		case 2:
			System.out.println("position.test");
			break;
		case 3:
			System.out.println("positon.ScrumMater");
			break;
		case 4:
			System.out.println("position.PM");
			break;
		default:
			System.out.println("unknown");
		}

		System.out.println("Nhap vao GroupID: ");
		int groupID = scanner.nextInt();

		System.out.println("Nhap Ngay tao(Theo dinh dang (yyyy/MM/dd): ");
		String dateInput = scanner.next();
		String pattern = "yyyy/MM/dd";
		SimpleDateFormat dateFormat = new SimpleDateFormat(pattern);
		Date createDate = dateFormat.parse(dateInput);
	}

	// Question6:
	public static void CreatDepartment() {
		Scanner scanner = new Scanner(System.in);
		System.out.println("Nhap ten Department muon tao:  ");
		String nameDepartment = scanner.next();
	}

	

}
