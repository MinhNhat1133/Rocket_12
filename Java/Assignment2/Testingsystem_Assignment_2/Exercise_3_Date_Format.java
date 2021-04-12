package program;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

public class Exercise_3_Date_Format {
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
		
			//========Date_Format=======//
			//Question1:
			System.out.println(exam1.createDate);
			Locale locale = new Locale ("vi","VN");
			DateFormat dateformat = DateFormat.getDateInstance(DateFormat.DEFAULT,locale);
			String date = dateformat.format(exam1.createDate);
			System.out.println(date);
			
			//QUestion2:
			String pattern = "yyyy-MM-dd-HH-mm-ss";
			SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern);
			Exam[] exams = { exam1, exam2 ,exam3 };
			for (Exam exam : exams) {
				date = simpleDateFormat.format(exam.createDate);
				System.out.println(exam.code + " Tao ngay: " + date);
			}
			//Question3:
			pattern = "yyyy";
			simpleDateFormat = new SimpleDateFormat(pattern);
			for (Exam exam : exams) {
				date = simpleDateFormat.format(exam.createDate);
				System.out.println(exam.code + "Tao nam:  " + date);
			}
			//Question4:
			pattern = "MM-yyyy";
			simpleDateFormat = new SimpleDateFormat(pattern);
			for (Exam exam : exams) {
				date = simpleDateFormat.format(exam.createDate);
				System.out.println(exam.code + " Tao vao:  " + date);
			}
			//Question5:
			pattern = "MM-dd";
			simpleDateFormat = new SimpleDateFormat(pattern);
			for (Exam exam : exams) {
				date = simpleDateFormat.format(exam.createDate);
				System.out.println(exam.code + " Tao vao:  " + date);
			}
			
}
}
