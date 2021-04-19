package com.vti.backend;

import java.time.LocalDate;

import com.vti.entity.Account;
import com.vti.entity.Department;
import com.vti.entity.Group;
import com.vti.entity.Position;

public class Exercise_1_Constructor {
	// ========== Question1 =========//
	// Tạo constructor cho department:
	// a) không có parameters
	// b) Có 1 parameter là nameDepartment và default id của
	// Department = 0
	public static void Q1() {
		System.out.println("\n//=== QUESTION 1 ===//");
		Department department1 = new Department();
		department1.setDepartmentID(1);
		Department department2 = new Department("sale");

		System.out.println( department1);
		System.out.println( department2);
	}

	// ============ Question2 =========//
	// Tạo constructor cho Account
	public static void Q2() {
		System.out.println("\n//=== QUESTION 2 ===//");
		// a : Không có parameters
		System.out.println("Question2_a: ");
		Account ac1 = new Account();
		ac1.setAccountID(1);
		ac1.setUserName("Dang123");
		System.out.println(ac1);
		/*
		 * b : Có các parameter là id, Email, Username, FirstName, LastName (với
		 * FullName = FirstName + LastName)
		 */
		System.out.println("Question2_b: ");
		Account ac2 = new Account(2, "VTI123@gmail.com", "BestSp", "Nguyen Ba", "Tung");
		System.out.println(ac2);

		// c: Có các parameter là id, Email, Username, FirstName,
		// LastName (với FullName = FirstName + LastName) và
		// Position của User, default createDate = now
		System.out.println("Question2_c: ");
		Position pos1 = new Position();
		pos1.setPositionID(1);
		pos1.setPositionName("abcd");
		Account ac3 = new Account(3, "VTI12345@gmail.com", "BestAd", "Tran Van", "Chung1", pos1);
		System.out.println(ac3);

		// d: Có các parameter là id, Email, Username, FirstName,
		// LastName (với FullName = FirstName + LastName) và
		// Position của User, createDate
		Account ac4 = new Account(4, "VTI12356@gmail.com", "BestKs", "Tran Van", "Chung2", pos1,
				LocalDate.parse("2021-04-19"));
		System.out.println(ac4);
	}

	// ============ Question3 =========//
	// Tao constructor cho Group
	public static void Q3() {
		System.out.println("\n//=== QUESTION 3 ===//");
		// //a: khong parameter
		System.out.println("Question3_a: ");
		Group gr1 = new Group();
		gr1.setGroupID(1);
		gr1.setGroupName("group LOL");
		System.out.println(gr1);
		// b: Có các parameter là GroupName, Creator, array Account[]
		// accounts, CreateDate
		System.out.println("Question3_b: ");
		Account creator = new Account(5, "test1@gmail.com", "Abc1", "Tran1", "Chung1");
		Account acc2 = new Account(6, "test2@gmail.com", "Abc2", "Tran2", "Chung2");
		Account acc3 = new Account(7, "test3@gmail.com", "Abc3", "Tran3", "Chung3");
		Account[] accounts = { creator, acc2, acc3 };
		Group gr2 = new Group("abc", creator, accounts, LocalDate.parse("2021-04-19"));
		System.out.println(gr2);
		// c:?????


	}

}
