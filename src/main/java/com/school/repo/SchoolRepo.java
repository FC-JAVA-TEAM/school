package com.school.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.school.entity.School;

@Repository
public interface SchoolRepo extends JpaRepository<School, Long>{

}
