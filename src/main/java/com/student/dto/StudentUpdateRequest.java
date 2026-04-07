package com.student.dto;

import jakarta.validation.constraints.Email;
import lombok.Data;

@Data
public class StudentUpdateRequest {
    private String name;
    private String course;

    @Email(message = "Email must be valid")
    private String email;
}
