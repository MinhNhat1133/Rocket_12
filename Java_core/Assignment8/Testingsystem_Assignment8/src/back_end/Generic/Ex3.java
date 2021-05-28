package back_end.Generic;

import entity.Generic.Student;

public class Ex3 {
	public void Q1_Q2() {
		Student<Integer> student1 = new Student<Integer>(1, "Nguyen Van A");

		Student<Float> student2 = new Student<Float>(2f, "Nguyen Van B");

		Student<Double> student3 = new Student<Double>(3.0, "Nguyen Van C");
		//in theo student
		print(student1);
		print(student2);
		print(student3);

		//in theo integer,float,downle,..
		print(1);
		print(2f);
		print(3d);
	}
	//Lenh de in ra cac doi tuong (vd nhu student1, student2,...) 
	//ta dat cho no mot ten dai dien cho cac doi tuong day la students
	private <T> void print(T a) {
		System.out.println(a);
	}

	private <T> void printArra(T[] arr) {
		for (T x : arr) {
			System.out.println(x);
		}
	}

}
