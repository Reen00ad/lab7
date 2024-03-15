package com.example.lab7.Service;

import com.example.lab7.Model.Student;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
@Service
public class StudentService {

    ArrayList<Student> students = new ArrayList<>();

    public ArrayList<Student> getStudents() {
        return students;
    }

    public void addStudent(Student student) {
        students.add(student);
    }

    public boolean updateStudent(int id, Student student) {
        for (int i = 0; i < students.size(); i++) {
            if (students.get(i).getId() == id) {
                students.set(i, student);
                return true;
            }
        }
        return false;
    }

    public boolean deleteStudent(int id) {
        for (int i = 0; i < students.size(); i++) {
            if (students.get(i).getId() == id) {
                students.remove(i);
                return true;
            }
        }
        return false;
    }

    public ArrayList<Student> getStudentByGrade() {
        ArrayList<Student> grades = new ArrayList<>();
        for (Student s : students) {
            if (s.getGrade() >= 50) {
                grades.add(s);
            }
        }
        return grades;
    }

    public boolean isgraduated(int id) {
        for (Student s : students) {
            if (s.getId() == id) {
                if (s.isGraduated() == false) {
                    if (s.getHours() == 50) {
                        s.setGraduated(true);
                        return true;
                    }
                }
            }
        }return false;
    }

    public ArrayList<Student> senior() {
        ArrayList<Student> ss = new ArrayList<>();
        for (Student s : students) {
            if (s.getLevel() >= 6) {
                ss.add(s);
            }
        }
        return ss;
    }

    public ArrayList<Student> majors(String major) {
        ArrayList<Student> m = new ArrayList<>();
        for (Student s : students) {
            if (s.getMajor().equalsIgnoreCase(major)) {
                m.add(s);
            }
        }
        return m;
    }
}