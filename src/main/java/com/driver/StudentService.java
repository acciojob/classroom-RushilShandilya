package com.driver;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class StudentService {
    StudentRepository studentRepository;
    public StudentService(){
        studentRepository = new StudentRepository();
    }
    public void addStudent(Student student){
        student.setStudentID(UUID.randomUUID());
        studentRepository.addStudent(student);
    }
    public void addTeacher(Teacher teacher){
        teacher.setTeacherID(UUID.randomUUID());
        studentRepository.addTeacher(teacher);
    }
    public List<String> getAllStudent(){
        return studentRepository.getAllStudent();
    }
    public List<String> getAllTeacher(){
        return studentRepository.getAllTeacher();
    }
    public Student getStudentDetails(String name){
        return studentRepository.getStudentDetails(name);
    }
    public Teacher getTeacherDetails(String name){
        return studentRepository.getTeacherDetails(name);
    }
    public List<String> getListOfStudentsUnderTeacher(String teacher){
        return studentRepository.getListOfStudentsUnderTeacher(teacher);
    }
    public void addStudentToTeacher(String student , String teacher){
        studentRepository.addStudentToTeacher(student,teacher);
    }
    public void deleteTeacherByName(String teacher){
        studentRepository.deleteTeacherByName(teacher);
    }
    public void deleteTeacher(){studentRepository.deleteAllTeachers();}
}
