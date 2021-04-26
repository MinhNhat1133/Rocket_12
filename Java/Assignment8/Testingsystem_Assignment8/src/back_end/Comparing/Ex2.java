package back_end.Comparing;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import entity.Comparing.Student;

public class Ex2 {
	private List<Student> ListStudent;

	public Ex2() {
		ListStudent = new ArrayList<>();
		NhapVaoStudent();
	}

	private void NhapVaoStudent() {
		ListStudent.add(new Student(1, "Nguyen A", LocalDate.parse("2021-04-20"), 6f));
		ListStudent.add(new Student(2, "Nguyen B", LocalDate.parse("2020-04-23"), 9.5f));
		ListStudent.add(new Student(3, "Nguyen C", LocalDate.parse("2021-03-29"), 5f));
		ListStudent.add(new Student(4, "Nguyen D", LocalDate.parse("2021-04-22"), 8.5f));
		ListStudent.add(new Student(5, "Nguyen E", LocalDate.parse("2021-04-25"), 8.2f));
		ListStudent.add(new Student(3, "Nguyen F", LocalDate.parse("2021-03-29"), 7f));
		ListStudent.add(new Student(4, "Nguyen G", LocalDate.parse("2020-04-22"), 9.5f));
		ListStudent.add(new Student(5, "Nguyen H", LocalDate.parse("2021-04-25"), 10));
		System.out.println("List student vua khoi tao: ");
		System.out.println(ListStudent);
	}

	private void XepTheoDiem() {
		System.out.println("Xap sep theo diem: ");
		Collections.sort(ListStudent, new Comparator<Student>() {
			@Override
			public int compare(Student st1, Student st2) {
				return st1.getDiem() > st2.getDiem() ? 1 : -1;
			}
		});
		// show list students
		for (Student student : ListStudent) {
			System.out.println(student.toString());
		}
	}

	private void XepTheoNgaySinh() {
		System.out.println("Xap sep theo ngay sinh: ");
		Collections.sort(ListStudent, new Comparator<Student>() {
			@Override
			public int compare(Student st1, Student st2) {
				return st1.getNgaySinh().compareTo(st2.getNgaySinh());
			}
		});
		// show list students
		for (Student student : ListStudent) {
			System.out.println(student.toString());
		}
	}

	private void XepTheoTen() {
		System.out.println("Xap xep theo ten: ");
		Collections.sort(ListStudent, new Comparator<Student>() {
			@Override
			public int compare(Student st1, Student st2) {
				return st1.getTen().compareTo(st2.getTen());
			}
		});
		for (Student student : ListStudent) {
			System.out.println(student.toString());
		}

	}

	public void Q1() {
		System.out.println("//======== Question1 ==========//");
		System.out.println("//====|| Xap xep theo ten ||===//");
		XepTheoTen();

	}

//	public void Q2() {
//		for(int i = 0 ; i < ListStudent.size();i++){
////		if (!ListStudent.get(i).getTen().equals(ListStudent.get(i++).getTen())){
////			XepTheoTen();
////		}else {
////			XepTheoNgaySinh();
////		}
//	}

}