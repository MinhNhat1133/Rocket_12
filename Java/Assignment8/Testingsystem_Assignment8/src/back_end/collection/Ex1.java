package back_end.collection;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import entity.collection.Student;

public class Ex1 {
	public void Q1() {
		List<Student> listStudents = new ArrayList<>();
		listStudents.add(new Student("Nam"));
		listStudents.add(new Student("Nam"));
		listStudents.add(new Student("Nam"));
		listStudents.add(new Student("Thuy"));
		listStudents.add(new Student("Hai"));
		
		System.out.println("Thong tin tat ca student");
		for (int i = 0; i < listStudents.size(); i++) {
			System.out.println("id: " + listStudents.get(i).getId() + "||" + "Ten: " + listStudents.get(i).getName());
		}
		System.out.println("(a). Tong so phan tu cua student la: " + listStudents.size());
		System.out.println("(b). Thong tin student thu 4 " + "id: " + listStudents.get(3).getId() + "||" + "Name: "
				+ listStudents.get(3).getName());
		//Lay ra phan tu dau va phan tu cuoi
		System.out.println("(c). Phan tu dau cua student:  " + listStudents.get(0).getId() + "||" + listStudents.get(0).getName());
		System.out.println("  Phan tu cuoi cua student: " + listStudents.get(listStudents.size() - 1).getId() + "||"
				+ listStudents.get(listStudents.size() - 1).getName());
		//Them 1 phan tu vao vi tri dau  
		System.out.println("(d). Thong tin tat ca student truoc khi them: ");
		System.out.println(listStudents);
		listStudents.add(0,new Student("Ngoc"));
		System.out.println("Sau khi sau khi them: ");
		System.out.println(listStudents);
		
		//Them vao vi tri cuoi 
		System.out.println("(e). Thong tin tat ca student truoc khi them: ");
		System.out.println(listStudents);
		listStudents.add(listStudents.size(),new Student("Minh"));
		System.out.println("Sau khi sau khi them: ");
		System.out.print(listStudents);
		
		//Dao nguoc vi tri dung Collections.reverse vd (123456)->(654321)
		Collections.reverse(listStudents);
		System.out.println("sau khi dao nguoc: ");
		System.out.println(listStudents);
	}
	public void Q6(){
		Map<Integer,String>ListStudent = new HashMap<>();
		ListStudent.put(1, "Nguyen Van A");
		ListStudent.put(2, "Nguyen Van B");
		ListStudent.put(3, "Nguyen Van C");
		ListStudent.put(4, "Nguyen Van D");
		ListStudent.put(5, "Nguyen Van E");
		
		for (Map.Entry<Integer,String> a : ListStudent.entrySet() ){
			System.out.println("iD: "+a.getKey() +" || "+ "Ten: "+ a.getValue());
			
		}
	}

}