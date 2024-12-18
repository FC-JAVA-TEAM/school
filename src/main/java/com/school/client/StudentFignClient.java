package com.school.client;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.school.dto.Student;


@FeignClient(name ="student-service", url ="${application.config.students-url}")
public interface StudentFignClient {

	
	@GetMapping("/students/{schoolId}")
	public List<Student> getAllStudentsBySchoolId(@PathVariable("schoolId") Integer schoolId) ;
}
