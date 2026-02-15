package com.student.Service;

import java.util.List;
import java.util.Map;
import org.springframework.stereotype.Service;

import com.student.Entity.Student;
import com.student.Repository.StudentRepo;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class StService {
    private final StudentRepo repo;
	
	public Map<String,Object> create(Student s) {
		Student st=repo.save(s);
		return Map.of("Student Details Are Added",st);
	}

	public Map<String, Object> fetch() {
		List<Student>st=repo.findAll();
		return Map.of("Students Detail",st);
	}

	public Map<String, Object> findByid(Long id,Student student) {
		Student st=repo.findById(id).orElseThrow(()->new RuntimeException("Student ID not Found"));
		if (student.getName()!=null) {
			st.setName(student.getName());
		}
		if (student.getCourse()!=null) {
			st.setCourse(student.getCourse());
		}
		if (student.getEmail()!=null) {
			st.setEmail(student.getEmail());
		}
		repo.save(st);
		return Map.of("Data Is Modified",st);
	}

	public void remove(Long id) {
		Student s=repo.findById(id).orElseThrow(()->new RuntimeException("Student ID Not Found"));
		if (s.getId()!=null) {
			repo.deleteById(id);	
		}
	}
}
