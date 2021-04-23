package com.vti.backend;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.vti.entity.Abstraction.News;

public class MyNews {

		private List<News> newsList;

		public MyNews() {
			newsList = new ArrayList<>();
		}

		public void insertNews() {
			News news = new News();
			int[] rates = new int[3];

			Scanner scanner = new Scanner(System.in);

			System.out.println("Nhap Title: ");
			news.setTitle(scanner.nextLine());

			System.out.println("Nhap Publish Date: ");
			news.setpublishDate(scanner.nextLine());

			System.out.println("Nhap Author: ");
			news.setAuthor(scanner.nextLine());

			System.out.println("Nhap Content: ");
			news.setcontent(scanner.nextLine());

			System.out.println("Nhap 3 rate : ");
			for (int i = 0; i < 3; i++) {
				System.out.println("Ðanh gia " + (i + 1) + ": ");
				rates[i] = scanner.nextInt();
			}
			news.setrate(rates);

			newsList.add(news);
		}

		public void viewListNews() {
			for (News news : newsList) {
				news.display();
			}
		}

		public void averageRate() {
			for (News news : newsList) {
				System.out.println("Title: " + news.gettitle() + " / Average Rate: " + news.caculator());
			}
		}
		

	}

