package com.vti.backend;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import com.vti.entity.Abstraction.News;;
public class MyNews {
	private List<News> newsList;

	public MyNews() {
		newsList = new ArrayList<>();
	}

	public void InsertNews() {
		News news = new News();
		int[] rates = new int[3];
		Scanner sc = new Scanner(System.in);
		System.out.println("Nhap vao title: ");
		news.setTitle(sc.nextLine());
		System.out.println("Nhap Publish Date: ");
		news.setpublishDate(sc.nextLine());

		System.out.println("Nhap Author: ");
		news.setAuthor(sc.nextLine());

		System.out.println("Nhap Content: ");
		news.setcontent(sc.nextLine());

		System.out.println("Nhap 3 ðanh gia: ");
		for (int i = 0; i < rates.length; i++) {
			System.out.println("Ðanh gia " + (i + 1) + ": ");
			rates[i] = sc.nextInt();
		}
		news.setrate(rates);

		newsList.add(news);
	}

	public void ViewListNew() {
		for (News news : newsList) {
			news.display();
		}

	}

	public void averageRate() {
		for (News news : newsList) {
			System.out.println("Title: " + news.gettitle() + " / Average Rate: " + news.caculate());
		}
	}
}
