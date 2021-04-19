package com.vti.backend;
import com.vti.entity.Encapsulation.Student;
import com.vti.entity.Encapsulation.Circle;
public class Exercise4_Encapsulation {
	//=======Question1========//
	public void Q1() {
		Student student1 = new Student("Thanh Nhi", "Ha Noi");
		student1.setId(1);
		student1.setScore(3);

		Student student2 = new Student("Thu Thao", "Ha Noi");
		student2.setId(2);
		student2.setScore(9);

		Student student3 = new Student("Hoang Minh", "Bac YEn");
		student3.setId(3);
		student3.setScore(6);
		
		student3.plusScore(2);

		System.out.println(student1);
		System.out.println(student2);
		System.out.println(student3);
	}
	//======= Question2 ========//
	public void Q2 (){
		Circle circle1 = new Circle(1.0,"Black");
		Circle circle2 = new Circle(1.5,"Red");
		Circle circle3 = new Circle(2.0,"Pink");
		Circle circle4 = new Circle(3.5,"Yellow");
		
		System.out.println(circle1);
		System.out.println(circle2);
		System.out.println(circle3);
		System.out.println(circle4);
	}

}
