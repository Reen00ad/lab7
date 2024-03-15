package com.example.lab7.Service;

import com.example.lab7.Model.Course;
import com.example.lab7.Model.Student;
import com.example.lab7.Model.Teacher;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.ArrayList;

@Service
public class CourseService {

    ArrayList<Course> courses=new ArrayList<>();

    public ArrayList<Course> getCourse() {
        return courses;
    }

    public void addCourse(Course course){
        courses.add(course);
    }

    public boolean updateCourse(int id,Course course){
        for (int i = 0; i < courses.size(); i++) {
            if(courses.get(i).getId()==id){
                courses.set(i,course);
                return true;
            }
        }
        return false;
    }

    public boolean deleteCourse(int id){
        for (int i = 0; i < courses.size(); i++) {
            if(courses.get(i).getId()==id){
                courses.remove(i);
                return true;
            }
        }
        return false;
    }

    public boolean isfull(int id) {
        for (Course c : courses) {
            if (c.getId() == id) {
                if (c.isFull() == false) {
                    if (c.getNumberofstudent() == 40) {
                        c.setFull(true);
                        return true;
                    }
                }
            }
}
        return false;}
    public ArrayList<Course> searchsta(@PathVariable String status) {
        ArrayList<Course> search = new ArrayList<>();
        for (Course c : courses) {
            if (c.getStatus().equalsIgnoreCase(status)) {
                search.add(c);

            }
        }
        return search;
    }

    public ArrayList<Course> gethours(int min, int max) {
        ArrayList<Course> h = new ArrayList<>();
        for (Course c : courses) {
            if (c.getHours() >= min && c.getHours() <= max) {
                h.add(c);
            }
        }
        return h;
    }
}
