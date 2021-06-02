package com.vti.demo;

import java.util.List;

import com.vti.entity.*;
import com.vti.repository.DepartmentRepository;

public class Program {
	public static void main(String[] args) {
		DepartmentRepository repository = new DepartmentRepository();

		System.out.println("***********GET ALL DEPARTMENTS (pageNumber,PageSize)***********");

		List<DepartmentDTO> departments = repository.getAllDepartments(2,3);

		for (DepartmentDTO department : departments) {
			System.out.println(department);
		}
		System.out.println("\n***********GET LIST DEPARTMENT BY ( field name) ***********");

		List<DepartmentDTO> departments2 = repository.getAllDepartmentsBYyfieldName("B");

		for (DepartmentDTO department : departments2) {
			System.out.println(department.toString());
		}
		System.out.println("\n***********GET TOTAL COUNT***********");
		System.out.println(repository.getTotalCount());

//		System.out.println("\n\n***********GET DEPARTMENT BY ID***********");
//
//		Department departmentById = repository.getDepartmentByID((int) 2);
//		System.out.println(departmentById);
//
//		System.out.println("\n\n***********GET DEPARTMENT BY NAME***********");
//
//		Department departmentByName = repository.getDepartmentByName("Marketting");
//		System.out.println(departmentByName);
//
//		System.out.println("\n\n***********CREATE DEPARTMENT***********");
//
//		Department departmentCreate = new Department();
//		departmentCreate.setName("waiting");
//		repository.createDepartment(departmentCreate);
//
//		System.out.println("\n\n***********UPDATE DEPARTMENT 1***********");
//
//		repository.updateDepartment((int) 3, "Security");
//
//		System.out.println("\n\n***********UPDATE DEPARTMENT 2***********");
//
//		Department departmentUpdate = new Department();
//		departmentUpdate.setId((int) 2);
//		departmentUpdate.setName("Security2");
//		repository.updateDepartment(departmentUpdate);

//		System.out.println("\n\n***********DELETE DEPARTMENTS***********");
//		repository.deleteDepartment((int) 2);

//		System.out.println("***********CHECK DEPARTMENT EXISTS BY ID***********");
//		System.out.println(repository.isDepartmentExistsByID((int) 1));
//
//		System.out.println("***********CHECK DEPARTMENT EXISTS BY NAME***********");
//		System.out.println(repository.isDepartmentExistsByName("Security"));

	}
}
