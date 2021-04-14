package program;

import java.util.Date;

public class Exercize1_FlowControl {
	@SuppressWarnings("deprecation")
	public static void main(String[] args) {
		// create department
		Department department1 = new Department();
		department1.departmentID = 1;
		department1.departmentName = "sale";

		Department department2 = new Department();
		department2.departmentID = 2;
		department2.departmentName = "marketing";

		Department department3 = new Department();
		department3.departmentID = 3;
		department3.departmentName = "BaoVe";

		// create position
		Position position1 = new Position();
		position1.positionID = 1;
		position1.positionName = "dev";

		Position position2 = new Position();
		position2.positionID = 2;
		position2.positionName = "test";

		Position position3 = new Position();
		position3.positionID = 3;
		position3.positionName = "PM";
		// create group
		Group group1 = new Group();
		group1.groupID = 1;
		group1.groupName = "GaMo";
		group1.CreateDate = new Date("2021/03/12");

		Group group2 = new Group();
		group2.groupID = 2;
		group2.groupName = "Testing";
		group2.CreateDate = new Date("2021/03/28");

		Group group3 = new Group();
		group3.groupID = 3;
		group3.groupName = "ProVip";
		group3.CreateDate = new Date("2021/04/02");

		// create account
		Account account1 = new Account();
		account1.accountID = 1;
		account1.email = "MinhNhat12@gamil.com";
		account1.username = "Tong";
		account1.fullName = "MinhNhat";
		account1.department = department1;
		account1.position = position1;
		Group[] groupOfAccount1 = { group1, group2 };
		account1.group = groupOfAccount1;
		account1.CreateDate = new Date("2021/02/01");

		Account account2 = new Account();
		account2.accountID = 2;
		account2.email = "DangKhoa@gamil.com";
		account2.username = "Nguyen";
		account2.fullName = "DangKhoa";
		account2.department = department2;
		account2.position = position2;
		Group[] groupOfAccount2 = { group1 };
		account2.group = groupOfAccount2;
		account2.CreateDate = new Date("2021/01/03");

		Account account3 = new Account();
		account3.accountID = 3;
		account3.email = "Mycute123@gamil.com";
		account3.username = "Tran";
		account3.fullName = "ThaoMy";
		account3.department = department3;
		account3.position = position3;
		Group[] groupOfAccount3 = { group1, group2, group3 };
		account3.group = groupOfAccount3;
		account3.CreateDate = new Date("2021/02/21");

		Account account4 = new Account();
		account4.accountID = 4;
		account4.email = "yasuo123@gamil.com";
		account4.username = "Huan";
		account4.fullName = "HoaHong";
		account4.department = department2;
		account4.position = position3;
		Group[] groupOfAccount4 = { group1, group2 };
		account4.group = groupOfAccount4;
		account4.CreateDate = new Date("2021/02/15");

		// creat accounts of group
		Account[] accountOfGroup1 = { account1, account2, account3 };
		group1.account = accountOfGroup1;

		Account[] accountOfGroup2 = { account3, account4 };
		group2.account = accountOfGroup1;

		Account[] accountOfGroup3 = { account4 };
		group3.account = accountOfGroup3;

		// Create TypeQuestion
		TypeQuestion typequestion1 = new TypeQuestion();
		typequestion1.TypeID = 1;
		typequestion1.TypeName = "Essay";

		TypeQuestion typequestion2 = new TypeQuestion();
		typequestion2.TypeID = 2;
		typequestion2.TypeName = "Essay";

		TypeQuestion typequestion3 = new TypeQuestion();
		typequestion3.TypeID = 3;
		typequestion3.TypeName = "Multiple-choice";

		// Create CategoryQuestion
		CategoryQuestion categoryquestion1 = new CategoryQuestion();
		categoryquestion1.categoryID = 1;
		categoryquestion1.categoryName = "java";

		CategoryQuestion categoryquestion2 = new CategoryQuestion();
		categoryquestion2.categoryID = 2;
		categoryquestion2.categoryName = "PHP";

		CategoryQuestion categoryquestion3 = new CategoryQuestion();
		categoryquestion3.categoryID = 3;
		categoryquestion3.categoryName = "Python";

		// Create Question
		Question question1 = new Question();
		question1.questionID = 1;
		question1.content = "1+1=?";
		question1.categoryQuestion = categoryquestion1;
		question1.account = account1;
		question1.createDate = new Date("2021/04/01");

		Question question2 = new Question();
		question2.questionID = 2;
		question2.content = "1+2=?";
		question2.categoryQuestion = categoryquestion3;
		question2.account = account1;
		question2.createDate = new Date("2021/04/02");

		Question question3 = new Question();
		question3.questionID = 1;
		question3.content = "1+3=?";
		question3.categoryQuestion = categoryquestion2;
		question3.account = account3;
		question3.createDate = new Date("2021/04/01");

		// create Answer
		Answer answer1 = new Answer();
		answer1.answerID = 1;
		answer1.content = "hai";
		answer1.question = question1;
		answer1.isCorrect = true;

		Answer answer2 = new Answer();
		answer2.answerID = 2;
		answer2.content = "hai";
		answer2.question = question2;
		answer2.isCorrect = false;

		Answer answer3 = new Answer();
		answer3.answerID = 3;
		answer3.content = "bon";
		answer3.question = question3;
		answer3.isCorrect = true;

		// create Exam
		Exam exam1 = new Exam();
		exam1.examID = 1;
		exam1.code = "VTI01";
		exam1.title = "TieuDeThi1";
		CategoryQuestion[] categoryQuestionOfExam1 = { categoryquestion1 };
		exam1.categoryQuestion = categoryQuestionOfExam1;
		exam1.account = account2;
		exam1.createDate = new Date("2021/04/03");

		Exam exam2 = new Exam();
		exam2.examID = 2;
		exam2.code = "VTI02";
		exam2.title = "TieuDeThi2";
		CategoryQuestion[] categoryQuestionOfExam2 = { categoryquestion1, categoryquestion3 };
		exam2.categoryQuestion = categoryQuestionOfExam2;
		exam2.account = account1;
		exam2.createDate = new Date("2021/04/04");

		Exam exam3 = new Exam();
		exam3.examID = 3;
		exam3.code = "VTI03";
		exam3.title = "TieuDeThi3";
		CategoryQuestion[] categoryQuestionOfExam3 = { categoryquestion2 };
		exam3.categoryQuestion = categoryQuestionOfExam3;
		exam3.account = account3;
		exam3.createDate = new Date("2021/04/03");

		// ========== IF ==========//
		// Question 1:
		if (account2.department == null) {
			System.out.println("Nhan vien nay khong co phong ban");
		} else {
			System.out.println("Phong ban cua nhan vien nay la : " + account2.department.departmentName);
		}

		// Question2:

		if (account2.group == null) {
			System.out.println("Nhan vien nay khong co group");
		} else if (account2.group.length == 1 || account2.group.length == 2) {
			System.out.println("group cua nhan vien nay la Java Fresher,CFresher");
		} else if (account2.group.length == 3) {
			System.out.println("Nhan vien nay quan trong tham gia nhieu group");

		} else if (account2.group.length >= 4) { // den day co the dung else roi
													// in ra luon.
			System.out.println("Nhan vien nay la nguoi hong chuyen tham gia tat ca cac group");
		}

		// Question3:
		System.out.println(account2.department == null ? "Nhan vien nay khog co phong ban "
				: "Nhan Vien nay co phong ban la : " + account2.department.departmentName);

		// Question4:
		System.out.println(
				account1.position.positionName == "dev" ? "Nhan vien la develope" : "Nhan Vien nay khong phai la Dev");

		// ========= SWITCH CASE =========//

		// Question5
		switch (group1.account.length) {
		case 1:
			System.out.println("Nhom co mot thanh vien");
			break;
		case 2:
			System.out.println("Nhom co hai thanh vien");
			break;
		case 3:
			System.out.println("nhom co ba thanh vien");
			break;
		default:
			System.out.println("Nhom co nhieu thanh vien");
		}
		// Question6
		int x = account3.group.length;
		switch (x) {
		case 0:
			System.out.println("Nhan vien nay chua co group");
			break;
		case 1:
		case 2:
			System.out.println("group cua nhan vien nay la Java fresher,C# fresher");
			break;
		case 3:
			System.out.println("Nhan vien nay la nguoi quan trong tham gia nhieu group");
			break;
		case 4:
			System.out.println("Nhan vien nay la nguoi hong chuyen, tham gia tat ca cac group");
		}

		// QUestion7:
		String y = account1.position.positionName;
		switch (y) {
		case "dev":
			System.out.println("Đây là Developer");
			break;
		default:
			System.out.println("Người này không phải là Developer");
		}

		// ========== FOREACH ==========//

		// Question 8:
		Account[] accounts = { account1, account2, account3 };
		for (Account account : accounts) {
			System.out.println("Email: " + account.email);
			System.out.println("FullName: " + account.fullName);
			System.out.println("Name Department: " + account.department.departmentName);
		}
		// Question 9 :
		Department[] departments = { department1, department2, department3 };
		for (Department department : departments) {
			System.out.println("id: " + department.departmentID);
			System.out.println("FullName: " + department.departmentName);
		}

		// =========== FOR ============//`
		// Question10:

		for (int i = 0; i < accounts.length; i++) {
			System.out.println("Thong tin account thu: " + (i + 1) + " la : ");
			System.out.println("Full Name : " + accounts[i].email);
			System.out.println("Email: " + accounts[i].position.positionName);
		}

		// Question 11:

		for (int i = 0; i < departments.length; i++) {
			System.out.println("Thong tin department thu " + (i + 1) + " la: ");
			System.out.println("id:  " + departments[i].departmentID);
			System.out.println("Name:" + departments[i].departmentName);
		}

		// Question12:
		for (int i = 0; i < 2; i++) {
			System.out.println("Thong tin department thu " + (i + 1) + " la: ");
			System.out.println("id:  " + departments[i].departmentID);
			System.out.println("Name:" + departments[i].departmentName);
		}

		// Question13:
		for (int i = 0; i < accounts.length; i++) {
			if (i != 1){
			System.out.println("Thong tin account thu: " + (i + 1) + " la : ");
			System.out.println("Full Name : " + accounts[i].email);
			System.out.println("Email: " + accounts[i].position.positionName);
		}}
		// Question14:
		for (int i = 0; i < accounts.length; i++) {
			if (accounts[i].accountID < 4){
			System.out.println("Thong tin account thu: " + (i + 1) + " la : ");
			System.out.println("Full Name : " + accounts[i].email);
			System.out.println("Email: " + accounts[i].position.positionName);
		}}
		// Question15:
		for (int i = 2; i <= 20; i = i + 2) {
			System.out.println(i);
		}
		;

		// ==========WHILE=========//
		//Question16_c10:
		int i = 0;
		while (i < accounts.length) {
			System.out.println("Thông tin account thứ " + (i + 1) + " là :");
			System.out.println("Email: " + accounts[i].email);
			System.out.println("Fullname: " + accounts[i].fullName);
			System.out.println("Department: " + accounts[i].department.departmentName);
			i++;
		}
		
		//Question16_c11:
		  i = 0;
		while ( i < departments.length ) {
			System.out.println("Thong tin department thu " + (i + 1) + " la: ");
			System.out.println("id:  " + departments[i].departmentID);
			System.out.println("Name:" + departments[i].departmentName);
			i++;
		}
		
		//Question16_c12:
		i = 0;
		while (i < 2) {
			System.out.println("Thong tin department thu " + (i + 1) + " là :");
			System.out.println("ID: " + departments[i].departmentID);
			System.out.println("Name: " + departments[i].departmentName);
			i++;
		}
		
		//Question16_c13:
		i = 0;
		while (i < departments.length) {

			if (i == 1) {
				i++;
				continue;
			}
			System.out.println("Thong tin department thu: " + (i + 1) + " là :");
			System.out.println("ID: " + departments[i].departmentID);
			System.out.println("Name: " + departments[i].departmentName);
			i++;
		}
		
		//Question16_c14
		i = 0;
		while (i < accounts.length) {
			if (accounts[i].accountID >= 4) {
				i++;
				continue;
			}
			System.out.println("Thong tin account thu:  " + (i + 1) + " là :");
			System.out.println("Email: " + accounts[i].email);
			System.out.println("Fullname: " + accounts[i].fullName);
			System.out.println("Department name: " + accounts[i].department.departmentName);
			i++;
		}
		
		//Question16_c15:
		
		}
		
		
		
	}
	
		

