package com.SpringPro1.restapi.repo;


import org.springframework.data.jpa.repository.JpaRepository;

import com.SpringPro1.restapi.entity.Student;


public interface StudentRepo extends JpaRepository<Student,Integer> {

	
}
