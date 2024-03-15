package com.example.lab7.Controller;

import com.example.lab7.ApiResponce.ApiResponce;
import com.example.lab7.Model.Student;
import com.example.lab7.Service.StudentService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
@RequestMapping("/api/v1/student")
@RequiredArgsConstructor
public class StudentController {

    private final StudentService studentService;


    @GetMapping("/get")
    public ResponseEntity getStudent(){
        ArrayList<Student> students=studentService.getStudents();
        return ResponseEntity.status(200).body(students);
    }


    @PostMapping("/add")
    public ResponseEntity addStudent(@RequestBody @Valid Student student, Errors errors){
        if(errors.hasErrors()){
            String message=errors.getFieldError().getDefaultMessage();
            return ResponseEntity.status(400).body(message);
        }
        studentService.addStudent(student);
        return ResponseEntity.status(200).body(new ApiResponce("student added"));
    }

    @PutMapping("/update/{id}")
    public ResponseEntity updateStudent(@PathVariable int id,@RequestBody @Valid Student student,Errors errors){
        if(errors.hasErrors()){
            String message=errors.getFieldError().getDefaultMessage();
            return ResponseEntity.status(400).body(message);
        }
        boolean isUpdated=studentService.updateStudent(id,student);
        if(isUpdated){
            return ResponseEntity.status(200).body(new ApiResponce("student updated"));
        }
        return ResponseEntity.status(400).body("not found");
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity deleteStudent(@PathVariable int id){
        boolean isDelete=studentService.deleteStudent(id);
        if(isDelete){
            return ResponseEntity.status(200).body(new ApiResponce("student deleted"));
        }
        return ResponseEntity.status(400).body(new ApiResponce("not found"));
    }

    @GetMapping("/pass")
    public ResponseEntity pass(){
      ArrayList<Student> s=studentService.getStudentByGrade();
        if(s==null){
            return ResponseEntity.status(400).body(new ApiResponce("not found"));
        }
        return ResponseEntity.status(200).body(s);
    }

    @PutMapping("/isgraduated/{id}")
    public ResponseEntity isgraduated(@PathVariable int id){
      boolean isgraduated=studentService.isgraduated(id);
      if(isgraduated){
        return ResponseEntity.status(200).body(new ApiResponce("done"));}
          return ResponseEntity.status(400).body(new ApiResponce("undone"));
    }

    @GetMapping("/senior")
    public ResponseEntity senior(){
        ArrayList<Student> s=studentService.senior();
        if(s==null){
            return ResponseEntity.status(400).body(new ApiResponce("not found"));
        }
        return ResponseEntity.status(200).body(s);
    }
    @GetMapping("/major/{major}")
    public ResponseEntity majors(@PathVariable String major){
        ArrayList<Student> m=studentService.majors(major);
        return ResponseEntity.status(200).body(m);


    }

}
