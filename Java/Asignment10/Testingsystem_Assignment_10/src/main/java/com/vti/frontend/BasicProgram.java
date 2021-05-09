package com.vti.frontend;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.SQLException;
import java.util.Scanner;

import com.vti.backend.Basic;

public class BasicProgram {
	private static Scanner scanner = new Scanner(System.in);

	public static void main(String[] args)
			throws ClassNotFoundException, FileNotFoundException, SQLException, IOException {

		// Q1:
		Basic basicProgram = new Basic();
		basicProgram.getConnection();

		// Q2:
		System.out.println("==== List position ====");
		basicProgram.showPositions();

		// Q3:
		System.out.println("Nhap Ten position muon tao: ");
		String name = scanner.nextLine();
		basicProgram.createPosition(name);
		System.out.println("=== List position sau khi them moi ===");
		basicProgram.showPositions();

		// Q4:
		basicProgram.updatePosition();
		System.out.println("=== List position sau khi Update ===");
		basicProgram.showPositions();

		// Q5:
		System.out.println("Nhap Id cua position muon xoa: ");
		int id = scanner.nextInt();
		basicProgram.DeletePosition(id);
		System.out.println("=== List position sau khi xoa ===");
		basicProgram.showPositions();

		// Close connection
		basicProgram.closeConnection();
	}

}
