package com.school.controller;

import java.util.List;
import java.util.Objects;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.school.dto.SchoolResponseData;
import com.school.entity.School;
import com.school.exception.BadRequestException;
import com.school.exception.ResourceNotFoundException;
import com.school.service.SchoolService;

@RestController
@RequestMapping("/api/v1/schools")
public class SchoolController {

	// Create a logger instance
	private static final Logger logger = LoggerFactory.getLogger(SchoolController.class);

	@Autowired
	private SchoolService service;

	@GetMapping
	public String welcome() {
		return "hello school service";
	}


    @PostMapping("/addschool")
    @ResponseStatus(HttpStatus.CREATED)
    public void addSchool(@RequestBody School school) {
        // Log request received
        logger.info("Received request to add school: {}", school);

        // Save the school to the database
        try {
            service.saveSchool(school);
            // Log success
            logger.info("Successfully added school: {}", school);
        } catch (Exception e) {
            // Log error if any
            logger.error("Error while adding school: {}", school, e);
            throw new BadRequestException("Failed to add school: " + e.getMessage());
        }
    }

    @GetMapping("/schools")
    public List<School> getAllSchool() {
        logger.info("Received request to get all schools");

        // Retrieve all schools from the service
        List<School> allSchools = service.getAllSchool();

        if (allSchools.isEmpty()) {
            logger.warn("No schools found");
            throw new ResourceNotFoundException("No schools found");
        } else {
            logger.info("Returning {} schools", allSchools.size());
        }

        return allSchools;
    }

    @GetMapping("/getallstudent/{school-id}")
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<SchoolResponseData> getAllStudentsBySchool(@PathVariable("school-id") Long schoolId) {
        // Log request received
        logger.info("Received request to get all students for school ID: {}", schoolId);

        // Validate if schoolId is null
        if (Objects.isNull(schoolId)) {
            // Log error if schoolId is null
            logger.error("Error while getting students by school ID: {}", schoolId);
            throw new BadRequestException("School ID cannot be null");
        }

        SchoolResponseData allStudents = service.findAllStudentBySchoolId(schoolId);
        if (allStudents == null || allStudents.getList().isEmpty()) {
            // Log no students found
            logger.warn("No students found for school ID: {}", schoolId);
            throw new ResourceNotFoundException("No students found for school with ID: " + schoolId);
        }

        // Log success
        logger.info("Successfully retrieved {} students for school ID: {}", allStudents.getList().size(), schoolId);

        return ResponseEntity.status(HttpStatus.OK).body(allStudents);
    }
}
