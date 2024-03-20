package bean;

import java.util.Objects;

public class Student {

	private String id;
	private String name;
	private Double scores;
	private Gender gender;
	
	public Student() {
	}
	
	public Student(String line) {
		String[] elements = line.split(", ");
		id = elements[0];
		name = elements[1];
		scores = Double.parseDouble(elements[2]);
		gender = "Nam".equals(elements[3]) ? Gender.Nam : Gender.Nu;
	}

	public Student(String id, String name, Double scores, Gender gender) {
		this.id = id;
		this.name = name;
		this.scores = scores;
		this.gender = gender;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Double getScores() {
		return scores;
	}

	public void setScores(Double scores) {
		this.scores = scores;
	}

	public Gender getGender() {
		return gender;
	}

	public void setGender(Gender gender) {
		this.gender = gender;
	}

	@Override
	public String toString() {
		return "Student [id=" + id + ", name=" + name + ", scores=" + scores + ", gender=" + gender + "]";
	}
	
	@Override
	public boolean equals(Object o) {
		if (this == o)
			return true;
		if (!(o instanceof Student))
			return false;
		Student that = (Student)o;
		return getId().equals(that.getId());
	}
	
	@Override
	public int hashCode() {
		return Objects.hash(getId());
	}
	
}
