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

		int choose;
		do {
			loadmenu();
			choose = scanner.nextInt();

			switch (choose) {

			case 1:
				myNews.insertNews();
				break;

			case 2:
				myNews.viewListNews();
				break;

			case 3:
				myNews.averageRate();
				myNews.viewListNews();
				break;

			case 4:
				break;

			default:
				System.out.println("fail !");
				break;
			}
		} while (choose != 4);
	}

	private static void loadmenu() {
		System.out.println("Nhap mot trong cac so duoi day de thuc hien tac vu: ");
		System.out.println("//========= MENU =========//");
		System.out.println("//==>  (1) Insert news    //");
		System.out.println("//==>  (2) View list news //");
		System.out.println("//==>  (3) Average rate   //");
		System.out.println("//==>  (4) Exit           //");
		System.out.println("\n==> Hay Nhap lua chon cua ban(1,2,3,4): ");
	}
}
