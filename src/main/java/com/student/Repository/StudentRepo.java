package com.student.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.student.Entity.Student;

public interface StudentRepo extends JpaRepository<Student,Long>{

}
