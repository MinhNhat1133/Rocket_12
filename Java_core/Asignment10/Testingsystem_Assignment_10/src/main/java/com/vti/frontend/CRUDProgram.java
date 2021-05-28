package com.vti.frontend;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.SQLException;
import java.util.Scanner;

import com.vti.backend.DepartmentDao;
import com.vti.entity.Department;

public class CRUDProgram {

	public static void main(String[] args) throws Exception {
		DepartmentDao depProgram = new DepartmentDao();
		// Q1:in ra list department
		depProgram.getListDep();
		// Q2_Q3: in ra thong tin department co id = 5 :
		Scanner sc = new Scanner(System.in);
		System.out.println("Nhap ID cua Department ban muon tra thong tin: ");
		int id = sc.nextInt();
		depProgram.showDepById(id);
		// Q4:tra xem tên của Dep có tồn tại trong Department hay chưa
		depProgram.xetTenTonTaiChua();
		// Q5:Tao department va check xem ten co bi trung khong
		System.out.println("Nhap ten cua Department ban muon tao: ");
		Scanner sc3 = new Scanner(System.in);
		String name = sc3.nextLine();
		depProgram.createDep(name);
		// Q6:Update (dang bi loi chua kip fix :D )
		// Scanner sc4 = new Scanner(System.in);
		// System.out.println("Nhap ID cua Department muon Update: ");
		// int id2 = sc4.nextInt();
		// System.out.println("Nhap Name cua Department muon Update: ");
		// String newName = sc4.nextLine();
		// depProgram.updateDepartment(id2, newName);
		// System.out.println("thanh cong");

		// Q7:
		System.out.println("Nhap ID cua Department ban muon xoa: ");
		Scanner sc5 = new Scanner(System.in);
		int id3 = sc5.nextInt();
		depProgram.deleteDep(id3);
	}
}