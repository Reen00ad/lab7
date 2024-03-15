package com.example.lab7.Service;

import com.example.lab7.Model.Student;
import com.example.lab7.Model.Teacher;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.ArrayList;

@Service
public class TeacherService {

    ArrayList<Teacher> teachers = new ArrayList<>();

    public ArrayList<Teacher> getTeacher() {
        return teachers;
    }

    public void addTeacher(Teacher teacher) {
        teachers.add(teacher);
    }

    public boolean updateTeacher(int id, Teacher teacher) {
        for (int i = 0; i < teachers.size(); i++) {
            if (teachers.get(i).getId() == id) {
                teachers.set(i, teacher);
                return true;
            }
        }
        return false;
    }

    public boolean deleteTeacher(int id) {
        for (int i = 0; i < teachers.size(); i++) {
            if (teachers.get(i).getId() == id) {
                teachers.remove(i);
                return true;
            }
        }
        return false;
    }

    public ArrayList<Teacher> searchposition(@PathVariable String position) {
        ArrayList<Teacher> search = new ArrayList<>();
        for (Teacher t : teachers) {
            if (t.getPosition().equalsIgnoreCase(position)) {
                search.add(t);

            }
        }
        return search;
    }

    public ArrayList<Teacher> getSalary(int min, int max) {
        ArrayList<Teacher> s = new ArrayList<>();
        for (Teacher t : teachers) {
            if (t.getSalary() >= min && t.getSalary() <= max) {
                s.add(t);
            }
        }
        return s;
    }

    public ArrayList<Teacher> getteacherposition(int salary, String position) {
        ArrayList<Teacher> s = new ArrayList<>();
        for (Teacher t : teachers) {
            if (t.getSalary() >= salary && t.getPosition().equalsIgnoreCase(position)) {
                s.add(t);
            }
        }
        return s;
    }



    public ArrayList<Teacher> coursenumbers() {
        ArrayList<Teacher> c = new ArrayList<>();
        for (Teacher t : teachers) {
            if (t.getNumberofcourse() == 3) {
                c.add(t);
            }
        }
        return c;
    }

}


