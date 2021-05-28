package com.vti.frontend;

import java.util.Scanner;

import com.vti.backend.MyNews;

public class Ex1_Abstraction {
	public static void main(String[] args) {
		Q1();
	}

	public static void Q1() {
		MyNews myNews = new MyNews();
		Scanner scanner = new Scanner(System.in);

		int eg;
		do {
			menu();
			eg = scanner.nextInt();

			switch (eg) {

			case 1:
				myNews.InsertNews();
				
				break;

			case 2:
				myNews.ViewListNew();
				break;

			case 3:
				myNews.averageRate();
				myNews.ViewListNew();
				break;

			case 4:
				break;

			default:
				System.out.println("fail !");
				break;
			}
		} while (eg != 4);
	}

	private static void menu() {
		System.out.println("Nhap mot trong cac so duoi day de thuc hien tac vu: ");
		System.out.println("//========= MENU =========//");
		System.out.println("//==>  (1) Insert news    //");
		System.out.println("//==>  (2) View list news //");
		System.out.println("//==>  (3) Average rate   //");
		System.out.println("//==>  (4) Exit           //");
	}
}
