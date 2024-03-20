package view;

import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Collection;
import java.util.Comparator;
import java.util.List;
import java.util.Objects;
import java.util.function.Function;
import java.util.stream.Collectors;

import bean.Gender;
import bean.Student;

public class Ex05 {
	
	private static final String pathName = "student.txt";

	public static void main(String[] args) throws Exception {
		var students = getStudents(pathName, Student::new);
		
		generate("Students sorted by DTB(asc), Name(asc)", 
				students.stream()
						.sorted(Comparator.comparing(Student::getScores).thenComparing(Student::getName))
						.toList());
		
		generate("Student has DTB > 8", 
				students.stream()
						.filter(student -> student.getScores() > 8)
						.toList());
		
		generate("Student has gender Nu", 
				students.stream()
						.filter(student -> student.getGender().equals(Gender.Nu))
						.toList());
		
		generate("Student only appears once", 
				students.stream()
						.distinct()
						.toList());
	}
	
	private static List<Student> getStudents(String path, Function<String, Student> function) throws Exception {
		return Files.readAllLines(Paths.get(path))
				.stream()
				.map(function)
				.filter(Objects::nonNull)
				.collect(Collectors.toList());
	}
	
	public static <T> void generate(String prefix, Collection<T> elements) {
		System.out.println(prefix + " {");
		elements.forEach(element -> System.out.println("    " + element));
		System.out.println("}\n");
	}
}
