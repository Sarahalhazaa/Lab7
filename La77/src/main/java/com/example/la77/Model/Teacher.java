package com.example.la77.Model;

import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.ArrayList;

@Data
@AllArgsConstructor
public class Teacher {

    @NotEmpty
    @Size(min = 10 ,max = 10)
    private String id;
    @NotEmpty
    @Pattern(regexp = "^[a-zA-Z]+$")
    private String name;
    @NotNull
    @Positive
    private int salary;
    @Pattern(regexp = "^05\\d{8}$")
    private String phoneNumber;
    @Email
    private String email;
    private ArrayList<Course> schedule;

}
