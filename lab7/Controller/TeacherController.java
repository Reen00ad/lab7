package com.example.lab7.Controller;

import com.example.lab7.ApiResponce.ApiResponce;
import com.example.lab7.Model.Student;
import com.example.lab7.Model.Teacher;
import com.example.lab7.Service.TeacherService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
@RequestMapping("/api/v1/teacher")
@RequiredArgsConstructor
public class TeacherController {
    private final TeacherService teacherService;

    @GetMapping("/get")
    public ResponseEntity getTeacher(){
        ArrayList<Teacher> teachers=teacherService.getTeacher();
        return ResponseEntity.status(200).body(teachers);
    }

    @PostMapping("/add")
    public ResponseEntity addTeacher(@RequestBody @Valid Teacher teacher, Errors errors){
        if(errors.hasErrors()){
            String message=errors.getFieldError().getDefaultMessage();
            return ResponseEntity.status(400).body(message);
        }
        teacherService.addTeacher(teacher);
        return ResponseEntity.status(200).body(new ApiResponce("teacher added"));
    }

    @PutMapping("/update/{id}")
    public ResponseEntity updateTeacher(@PathVariable int id, @RequestBody @Valid Teacher teacher,Errors errors){
        if(errors.hasErrors()){
            String message=errors.getFieldError().getDefaultMessage();
            return ResponseEntity.status(400).body(message);
        }
        boolean isupdated=teacherService.updateTeacher(id,teacher);
        if(isupdated){
            return ResponseEntity.status(200).body(new ApiResponce("teacher updated"));
        }
        return ResponseEntity.status(400).body(new ApiResponce("not found"));
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity deleteTeacher(@PathVariable int id){
        boolean isdeleted=teacherService.deleteTeacher(id);
        if(isdeleted){
            return ResponseEntity.status(200).body(new ApiResponce("teacher deleted"));
        }
        return ResponseEntity.status(400).body("not found");
    }

    @GetMapping("/position/{positions}")
    public ResponseEntity position(@PathVariable String positions){
        ArrayList<Teacher> t=teacherService.searchposition(positions);
        if(t==null){
            return ResponseEntity.status(400).body(new ApiResponce("not found"));
        }
        return ResponseEntity.status(200).body(t);
    }

    @GetMapping("/salary/{min}/{max}")
    public ResponseEntity slary(@PathVariable int min,@PathVariable int max){
        ArrayList<Teacher> t=teacherService.getSalary(min,max);
        if(t==null){
            return ResponseEntity.status(400).body(new ApiResponce("not found"));
        }
        return ResponseEntity.status(200).body(t);
    }
    @GetMapping("/posandsalary/{salary}/{position}")
    public ResponseEntity posandsalary(@PathVariable int salary,@PathVariable String position){
        ArrayList<Teacher> t=teacherService.getteacherposition(salary,position);
        if(t==null){
            return ResponseEntity.status(400).body(new ApiResponce("not found"));
        }
        return ResponseEntity.status(200).body(t);
    }
    @GetMapping("/courseno")
    public ResponseEntity courseno(){
        ArrayList<Teacher> t=teacherService.coursenumbers();
        if(t==null){
            return ResponseEntity.status(400).body(new ApiResponce("not found"));
        }
        return ResponseEntity.status(200).body(t);
    }

}
