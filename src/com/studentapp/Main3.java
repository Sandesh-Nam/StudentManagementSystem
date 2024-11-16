package com.studentapp;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

public class Main3 {

	private static List<Student> studentList;

	public static void main(String[] args) {
		System.out.println("**** Student Management System ****");
		System.out.println("*** Welcome ***");
		studentList = new ArrayList<Student>();
		
		Scanner scanner = new Scanner(System.in);
		System.out.println("Enter Student Name....");
		String name = scanner.next(); //If you read input in string format.
		System.out.println("You have entered the name "+name);
		
		System.out.println("Enter Student Age....");
		int age = scanner.nextInt(); //to read input for int format
		System.out.println("The Student age is "+age);
		
	}

	private static void sortByName() {
		Comparator<Student> studentNameComparator = (o1, o2) -> o1.getName().compareTo(o2.getName());
			/*
			@Override
			public int compare(Student o1, Student o2) {
				return o1.getName().compareTo(o2.getName()); //It will compare based on alphabetical order
			}
			
		}; */
		Collections.sort(studentList, studentNameComparator);
		System.out.println(studentList);
		
	}

	public static Student findStudentById(String studentId) {
		Student result = null; //explicit initialization
		try {
		result = studentList
				.stream().filter(x -> x.getStudentId().equalsIgnoreCase(studentId))
				.findFirst()
				.orElseThrow(() -> new RuntimeException("No Data Found!!!"));
		}catch(RuntimeException e) {
			System.err.println("Student with ID "+studentId+" not found!!");
		}
		return result;
	}
}
