package com.school.dto;

import java.util.List;

public class SchoolResponseData {

	private String schoolName;
	private String email;

	private List<Student> list;

	public String getSchoolName() {
		return schoolName;
	}

	public void setSchoolName(String schoolName) {
		this.schoolName = schoolName;
	}

	@Override
	public String toString() {
		return "SchoolResponseData [schoolName=" + schoolName + ", email=" + email + ", list=" + list + "]";
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public List<Student> getList() {
		return list;
	}

	public void setList(List<Student> list) {
		this.list = list;
	}
}
