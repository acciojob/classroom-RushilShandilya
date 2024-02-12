package com.driver;

import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@Repository
public class StudentRepository {
    HashMap<String,Student> studentDB;
    HashMap<String,Teacher> teacherDB;
    HashMap<String,List<String>> studentTeacherPair;

    public StudentRepository(){
        studentDB = new HashMap<>();
        teacherDB = new HashMap<>();
        studentTeacherPair = new HashMap<>();
    }
    public void addStudent(Student student){studentDB.put(student.getName(),student);}
    public void addTeacher(Teacher teacher){teacherDB.put(teacher.getName(),teacher);}

    public List<String> getAllStudent(){
        return new ArrayList<>(studentDB.keySet());
    }
    public Student getStudentDetails(String name){
        return studentDB.get(name);
    }
    public void addStudentToTeacher(String student,String teacher){
        if(studentTeacherPair.isEmpty() || !studentTeacherPair.containsKey(teacher)) studentTeacherPair.put(teacher,new ArrayList<>());
        List<String> studentList = studentTeacherPair.get(teacher);
        studentList.add(student);
        studentTeacherPair.put(teacher,studentList);
    }
    public Teacher getTeacherDetails(String name){return teacherDB.get(name);}
    public List<String> getListOfStudentsUnderTeacher(String teacher){return studentTeacherPair.get(teacher);}
    public void deleteTeacherByName(String teacher){
        for(String studentName : studentTeacherPair.get(teacher)) studentDB.remove(studentName);
        teacherDB.remove(teacher);
        studentTeacherPair.remove(teacher);
    }
    public void deleteAllTeachers(){
       for(String teacher : studentTeacherPair.keySet()) {
           for (String student : studentTeacherPair.get(teacher)) studentDB.remove(student);
           teacherDB.remove(teacher);
       }
       studentTeacherPair.clear();
    }
}
