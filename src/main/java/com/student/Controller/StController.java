package com.student.Controller;

import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.student.Entity.Student;
import com.student.Service.StService;

import lombok.RequiredArgsConstructor;
@RestController
@RequiredArgsConstructor
@RequestMapping("/student")
public class StController {
      
	private final StService service ;
	@PostMapping("/create")
	@ResponseStatus(HttpStatus.CREATED)
	public Map<String, Object> create(@RequestBody Student s) {
		return service.create(s); 
	}
	@GetMapping("/view")
	@ResponseStatus(HttpStatus.OK)
	public Map<String,Object>fetch(){
		return service.fetch();
	}
	@PatchMapping("/modify/{id}")
	@ResponseStatus(HttpStatus.OK)
	public Map<String,Object>change(@PathVariable Long id,@RequestBody Student student){
		return service.findByid(id,student);
	}
	@DeleteMapping("/remove/{id}")
	@ResponseStatus(HttpStatus.OK)
	public void remove(@PathVariable Long id){
		service.remove(id);
	}
}
