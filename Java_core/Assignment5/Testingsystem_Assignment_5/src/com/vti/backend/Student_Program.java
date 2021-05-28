package com.vti.backend;

import com.vti.enity.polymorphism.Student;

public class Student_Program {

	private Student[] students;

	public Student_Program() {
		students = new Student[10];
	}

	public void dsStudents() {
		students[0] = new Student(1, "Thang", 1);
		students[1] = new Student(2, "Quang", 1);
		students[2] = new Student(3, "Nguyen", 1);
		students[3] = new Student(4, "Huy", 2);
		students[4] = new Student(5, "Thuy", 2);
		students[5] = new Student(6, "Phuong", 2);
		students[6] = new Student(7, "Phong", 3);
		students[7] = new Student(8, "Khoang", 3);
		students[8] = new Student(9, "An", 3);
		students[9] = new Student(10, "Dat", 3);
	}

	public void caLopDiemDanh() {
		for (int i = 0; i < students.length; i++) {
			students[i].diemDanh();
		}
	}
	public void nhomDiHocBai() {
		for (int i = 0; i < students.length; i++) {
			if (students[i].getGroup() == 1) {
				students[i].hocBai();
			}
		}
	}

	public void nhomDiDonVeSinh() {
		for (int i = 0; i <  students.length; i++) {
			if (students[i].getGroup() == 2) {
				students[i].diDonVeSinh();
			}
		}
	}
}
	

