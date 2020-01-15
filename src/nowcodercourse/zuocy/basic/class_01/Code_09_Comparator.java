package nowcodercourse.zuocy.basic.class_01;

import lombok.Data;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

public class Code_09_Comparator {

	@Data
	public static class Student {
		public String name;
		public int id;
		public int age;

		public Student(String name, int id, int age) {
			this.name = name;
			this.id = id;
			this.age = age;
		}
	}

	public static class IdAscendingComparator implements Comparator<Student> {

		@Override
		public int compare(Student o1, Student o2) {
			return o1.id - o2.id;
		}

	}

	public static class IdDescendingComparator implements Comparator<Student> {

		@Override
		public int compare(Student o1, Student o2) {
			return o2.id - o1.id;
		}

	}

	public static class AgeAscendingComparator implements Comparator<Student> {

		@Override
		public int compare(Student o1, Student o2) {
			return o1.age - o2.age;
		}

	}

	public static class AgeDescendingComparator implements Comparator<Student> {

		@Override
		public int compare(Student o1, Student o2) {
			return o2.age - o1.age;
		}

	}

	public static void printStudents(Student[] students) {
		for (Student student : students) {
			System.out.println("Name : " + student.name + ", Id : " + student.id + ", Age : " + student.age);
		}
		System.out.println("===========================");
	}

	public static void main(String[] args) {
		Student student1 = new Student("A", 1, 23);
		Student student2 = new Student("B", 1, 21);
		Student student3 = new Student("C", 3, 22);

		Student[] students = new Student[] { student3, student2, student1 };
		printStudents(students);

//		Arrays.sort(students, new IdAscendingComparator());
//		printStudents(students);
//
//		Arrays.sort(students, new IdDescendingComparator());
//		printStudents(students);
//
//		Arrays.sort(students, new AgeAscendingComparator());
//		printStudents(students);
//
//		Arrays.sort(students, new AgeDescendingComparator());
//		printStudents(students);

//		Arrays.sort(students, Comparator.comparing((Student::getId)));

//		Arrays.sort(students, (o1,o2)->
//			o1.getId()-o2.getId()!=0?o1.getId()-o2.getId()
//				:o1.getAge()-o2.getAge());
//		printStudents(students);

		PriorityQueue<Student> queue = new PriorityQueue<>(Comparator.comparing(Student::getId));
		queue.add(student1);
		queue.add(student2);
		queue.add(student3);
		queue.forEach(student -> System.out.println(student.toString()));


	}

}
