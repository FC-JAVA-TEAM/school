package com.school.dto;

public class Student {

	private String studentFirstName;
	private String studentLastName;
	private String email;
	public String getStudentFirstName() {
		return studentFirstName;
	}
	public void setStudentFirstName(String studentFirstName) {
		this.studentFirstName = studentFirstName;
	}
	public String getStudentLastName() {
		return studentLastName;
	}
	public void setStudentLastName(String studentLastName) {
		this.studentLastName = studentLastName;
	}
	public String getEmail() {
		return email;
	}
	public Student() {
		super();
		// TODO Auto-generated constructor stub
	}
	@Override
	public String toString() {
		return "Student [studentFirstName=" + studentFirstName + ", studentLastName=" + studentLastName + ", email="
				+ email + "]";
	}
	public void setEmail(String email) {
		this.email = email;
	}
}
