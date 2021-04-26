package com.vti.frontend;

import com.vti.backend.Student_Program;

public class Ex1_Polymorphism {
	public static void main(String[] args) {
		Student_Program studentManagement = new Student_Program();

		studentManagement.dsStudents();
		studentManagement.caLopDiemDanh();
		studentManagement.nhomDiHocBai();
		studentManagement.nhomDiDonVeSinh();
	}
}
