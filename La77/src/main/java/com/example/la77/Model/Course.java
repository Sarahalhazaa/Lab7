package com.example.la77.Model;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.sql.Time;
import java.util.HashMap;

@Data
@AllArgsConstructor
public class Course {

    @NotNull
    @Max(4)
    private int hours;
    @NotEmpty
    private String nameCourse;
    @NotNull
    @Size(max = 6)
    private String id;
    @NotNull
    private String numberClass;
    @NotNull
    @Pattern(regexp = "^(Sunday|Monday|Tuesday|Wednesday|Thursday)$")
    private String day;
    @JsonFormat(pattern = "HH:mm:ss")
    private Time time;
    @Min(0)
    @Max(100)
    private int grade;


}
