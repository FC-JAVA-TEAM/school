package com.school.service;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.school.client.StudentFignClient;
import com.school.dto.SchoolResponseData;
import com.school.dto.Student;
import com.school.entity.School;
import com.school.exception.ResourceNotFoundException;
import com.school.exception.BadRequestException;
import com.school.exception.GenericException;
import com.school.repo.SchoolRepo;

import feign.FeignException;

@Service
public class SchoolService {

    @Autowired
    private SchoolRepo schoolRepo;

    @Autowired
    private StudentFignClient fignClient;

    // Save school
	/*
	 * public void saveSchool(School school) { try { if (school == null ||
	 * school.getSchoolName() == null || school.getEmail() == null) { throw new
	 * BadRequestException("School data is incomplete or invalid."); }
	 * schoolRepo.save(school); } catch (BadRequestException ex) { throw ex; //
	 * Rethrow the BadRequestException if validation fails } catch (Exception ex) {
	 * throw new GenericException("Error occurred while saving school", ex); //
	 * Generic error handling } }
	 * 
	 * // Get all schools public List<School> getAllSchool() { try { return
	 * schoolRepo.findAll(); } catch (Exception ex) { throw new
	 * GenericException("Error occurred while retrieving all schools", ex); //
	 * Generic error handling } }
	 * 
	 * // Get students by school ID public SchoolResponseData
	 * findAllStudentBySchoolId(Long schoolId) { // Check if the school exists
	 * Optional<School> schoolOptional = schoolRepo.findById(schoolId); if
	 * (!schoolOptional.isPresent()) { throw new
	 * ResourceNotFoundException("School with ID " + schoolId + " not found."); }
	 * 
	 * School school = schoolOptional.get();
	 * 
	 * // Call the student service using Feign client List<Student>
	 * allStudentsBySchoolId; try { allStudentsBySchoolId =
	 * fignClient.getAllStudentsBySchoolId(school.getId().intValue()); } catch
	 * (FeignException e) { // Handle the Feign client exception (external service
	 * failure) throw new
	 * GenericException("Failed to fetch students for school ID: " + schoolId, e); }
	 * 
	 * // Prepare and return the response SchoolResponseData response = new
	 * SchoolResponseData(); response.setEmail(school.getEmail());
	 * response.setSchoolName(school.getSchoolName());
	 * response.setList(allStudentsBySchoolId);
	 * 
	 * return response; }
	 */
}
