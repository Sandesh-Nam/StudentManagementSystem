package com.studentapp;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Student {
	// instance variables
	private String name;
	private int age;
	private String studentId;
	private List<String> courses; // Because of Generics, course will always be String

	public Student(String name, int age, String studentID) {
		super();
		if (validateAge(age) && validateName(name) && validateStudentId(studentID)) {
			this.name = name;
			this.age = age;
			this.studentId = studentID;
			courses = new ArrayList<String>();// Initialization of courses
		}
	}

	public void enrollCourse(String course) {
		if(validateCourseName(course)) {
		if (!courses.contains(course)) { // check duplicate course should not be added
			courses.add(course);// It will only take String value because we initialised that way
			System.out.println("Student is enrolled to " + course + " successfully!!");
		} else {
			System.err.println("Student is already enrolled to the Course " + course);
		}}
	}

	public void printStudentInfo() {
		System.out.println("====Student Information ====");
		System.out.println("Student Name: " + name);
		System.out.println("Student Age: " + age);
		System.out.println("Student Id: " + studentId);
		System.out.println("Enrolled For: " + courses);

	}

	@Override
	public String toString() {
		return "Student [name=" + name + ", age=" + age + ", studentID=" + studentId + ", courses=" + courses + "]";
	}

	// Validation Methods
	public boolean validateAge(int age) {
		if (age >= 19 && age <= 35) {
			return true;
		} else {
			System.err.println("Invalid age!!! Student Age needs to be between 19 and 35");
			return false;
		}
	}

	public boolean validateName(String name) {
		// kajal KAJAL Kajal 'KaJAL Talreja'
		String nameRegex = "^[a-zA-Z\\s]+$";
		Pattern namePattern = Pattern.compile(nameRegex);
		Matcher nameMatcher = namePattern.matcher(name);
		if (nameMatcher.matches()) {
			return true;
		} else {
			System.err.println("Invalid Name!!! Please enter alphabets only");
			return false;
		}
	}

	public boolean validateStudentId(String studentId) {
		String studentIdRegex = "S-\\d+$"; // S-123 and d here means digit
		Pattern studentIdPattern = Pattern.compile(studentIdRegex); // creating pattern and compile() compiles the given
																	// regex
		Matcher studentIdMatcher = studentIdPattern.matcher(studentId);
		if (studentIdMatcher.matches()) {
			return true;
		} else {
			System.err.println("Invalid Student Id.... Use the format Eg...S-123");
			return false;
		}
	}

	public boolean validateCourseName(String course) {
		if (course.equalsIgnoreCase("Java") || course.equalsIgnoreCase("DSA") || 
				course.equalsIgnoreCase("DevOps")) {
			return true;
		} else {
			System.err.println("Invalid Course Name!!! Please select Courses from the List!! [Java,DSA,DevOps]");
			return false;
		}
	}

	public String getName() {
		return name;
	}

	public int getAge() {
		return age;
	}

	public String getStudentId() {
		return studentId;
	}

	public List<String> getCourses() {
		return courses;
	}
	
}
