package com.studentapp;

public class Main {

	public static void main(String[] args) {
		System.out.println("**** Student Management System ****");
		System.out.println("*** Welcome ***");

		Student s1;
		s1 = new Student("Kajal", 22, "S-1");
		s1.enrollCourse("Java");
		s1.enrollCourse("Dsa");
		s1.enrollCourse("DevOPS");
		s1.printStudentInfo();
		Student s2 = new Student("Uday", 24, "S-2");
		s2.enrollCourse("JAVA");
		s2.enrollCourse("DevOps");
		s2.printStudentInfo();
		Student s3 = new Student("Ritu", 27, "S-3");
		s3.enrollCourse("DSA");
		s3.enrollCourse("JAVA");
		s3.printStudentInfo();
		
	}
}
