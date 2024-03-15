package com.example.lab7.Model;

import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Teacher {
    @NotNull(message = "id cannot be null")
    private int id;
    @NotEmpty(message = "name cannot be empty")
    private String name;
    @Email(message = "enter valid email")
    private String email;
    @Pattern(regexp ="^05?[0-9]+$", message = "phone number must start with 05")
    @Size(min = 10,max = 10,message = "number must be 10 diget")
    private String phonenumber;
    @NotNull( message = "number of course cannot be null")
    @Max(value = 3,message = "max number of course is 3")
    private int numberofcourse;
    @NotEmpty(message = "position should not be null")
    @Pattern(regexp ="^(fulltime|parttime)$", message = "position must be fulltime or parttime only")
    private String position;
    @NotNull(message = "salary cannot be null")
    @Min(value = 3000,message = "salary must be greater than 3000")
    private int salary;

}
