package com.example.lab7.Model;

import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Student {
    @NotNull(message = "id cannot be null")
    private int id;
    @NotEmpty(message = "name cannot be empty")
    private String name;
    @Email(message = "enter valid email")
    private String email;
    @Pattern(regexp ="^05?[0-9]+$", message = "phone number must start with 05")
    @Size(min = 10,max = 10,message = "number must be 10 diget")
    private String phonenumber;
    @NotNull(message = "level cannot be null")
    @Max(value = 8,message = "level cannot be greater than 8")
    private int level;
    @NotEmpty(message = "major cannot be empty")
    private String major;
    @NotNull(message = "grade cannot be null")
    @Max(value = 100,message = "grade cannot be greater than 100")
    private int grade;
    @NotNull(message = "hours cannot be null")
    @Max(50)
    private int hours;
    @AssertFalse
    private boolean graduated;
}
