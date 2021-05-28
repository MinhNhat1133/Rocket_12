package entity.collection;

public class Student {
	private static int count = 1;

	private int id;
	private String name;

	public Student(String name) {
		this.id = count++;
		this.name = name;

	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return "Id: " + id + "||" + "Ten: " + name;
	}

	public int compareTo(Student student) {
		if (name.compareTo(student.name) > 0) {
			return 1;
		}

		if (name.compareTo(student.name) < 0) {
			return -1;
		}

		return 0;
	}

}
