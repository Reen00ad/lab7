package com.example.lab7.Controller;

import com.example.lab7.ApiResponce.ApiResponce;
import com.example.lab7.Model.Course;
import com.example.lab7.Model.Teacher;
import com.example.lab7.Service.CourseService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
@RequestMapping("/api/v1/course")
@RequiredArgsConstructor
public class CourseController {
    private final CourseService courseService;

    @GetMapping("/get")
    public ResponseEntity getCourse(){
        ArrayList<Course> courses=courseService.getCourse();
        return ResponseEntity.status(200).body(courses);
    }

    @PostMapping("/add")
    public ResponseEntity addCourse(@RequestBody @Valid Course course, Errors errors){
        if(errors.hasErrors()){
            String message=errors.getFieldError().getDefaultMessage();
            return ResponseEntity.status(400).body(message);
        }
        courseService.addCourse(course);
        return ResponseEntity.status(200).body(new ApiResponce("course added"));
    }

    @PutMapping("/update/{id}")
    public ResponseEntity updateCourse(@PathVariable int id, @RequestBody @Valid Course course,Errors errors){
        if(errors.hasErrors()){
            String message=errors.getFieldError().getDefaultMessage();
            return ResponseEntity.status(400).body(message);
        }
        boolean isupdated=courseService.updateCourse(id,course);
        if(isupdated){
            return ResponseEntity.status(200).body(new ApiResponce("course updated"));
        }
        return ResponseEntity.status(400).body(new ApiResponce("not found"));
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity deleteCourse(@PathVariable int id){
        boolean isdeleted=courseService.deleteCourse(id);
        if(isdeleted){
            return ResponseEntity.status(200).body(new ApiResponce("teacher deleted"));
        }
        return ResponseEntity.status(400).body("not found");
    }

    @PutMapping("/isfull/{id}")
    public ResponseEntity isfull(@PathVariable int id){
        boolean isfull=courseService.isfull(id);
        if(isfull){
            return ResponseEntity.status(200).body(new ApiResponce("done"));}
        return ResponseEntity.status(400).body(new ApiResponce("undone"));
    }
    @GetMapping("/status/{status}")
    public ResponseEntity getstatus(@PathVariable String status){
        ArrayList<Course> c=courseService.searchsta(status);
        if(c==null){
            return ResponseEntity.status(400).body(new ApiResponce("not found"));
        }
        return ResponseEntity.status(200).body(c);
    }
    @GetMapping("/hours/{min}/{max}")
    public ResponseEntity hours(@PathVariable int min,@PathVariable int max){
        ArrayList<Course> c=courseService.gethours(min,max);
        if(c==null){
            return ResponseEntity.status(400).body(new ApiResponce("not found"));
        }
        return ResponseEntity.status(200).body(c);
    }
}
