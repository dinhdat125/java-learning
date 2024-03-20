package bean;

public class Student {

	private int id;
	private String name;
	private Ranked rank;
	
	public Student() {
	}

	public Student(int id, String name, Ranked rank) {
		this.id = id;
		this.name = name;
		this.rank = rank;
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

	public Ranked getRank() {
		return rank;
	}

	public void setRank(Ranked rank) {
		this.rank = rank;
	}

	public String toString() {
		return "Mã sinh viên: " + id + ", Họ tên: " + name + ", Xếp loại: " + rank;
	}
	
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!(this instanceof Student))
			return false;
		Student that = (Student)obj;
		return getId() ==  that.getId();
	}
}
