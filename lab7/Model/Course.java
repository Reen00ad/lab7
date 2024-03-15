package com.example.lab7.Model;

import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Course {
    @NotNull(message = "id cannot be null")
    private int id;
    @NotEmpty(message = "name cannot be empty")
    private String name;
    @NotNull(message = "hourse cannot be null")
    @Max(8)
    private int hours;
    @NotEmpty(message = "status cannot be empty")
    @Pattern(regexp ="^(offline|online)$", message = "course must be offline or online")
    private String status;
    @NotNull
    @Max(value = 40,message = "max number of students is 40")
    private int numberofstudent;
    @AssertFalse
    private boolean isFull;
}
