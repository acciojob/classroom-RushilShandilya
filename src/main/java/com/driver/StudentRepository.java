package com.driver;

import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.UUID;

@Repository
public class StudentRepository {
    HashMap<UUID,Student> studentDB;
    HashMap<UUID,Teacher> teacherDB;
    HashMap<Student,Teacher> studentTeacherPair;

    public StudentRepository(){
        studentDB = new HashMap<>();
        teacherDB = new HashMap<>();
        studentTeacherPair = new HashMap<>();
    }
    public void addStudent(Student student){
        studentDB.put(UUID.randomUUID(),student);
    }
    public void addTeacher(Teacher teacher){
        teacherDB.put(UUID.randomUUID(),teacher);
    }

    public List<String> getAllStudent(){
       List<String> listOfStudentName = new ArrayList<>();
       for(UUID studentID : studentDB.keySet()) listOfStudentName.add(studentDB.get(studentID).getName());
       return listOfStudentName;
    }
    public List<String> getAllTeacher(){
        List<String> listOfTeacherName = new ArrayList<>();
        for(UUID teacherID: studentDB.keySet()) listOfTeacherName.add(teacherDB.get(teacherID).getName());
        return listOfTeacherName;
    }
    public Student getStudentDetails(String name){
        for(UUID studentID : studentDB.keySet()) if(studentDB.get(studentID).getName().equals(name)) return studentDB.get(studentID);
        return null;
    }
    public Teacher getTeacherDetails(String name){
        for(UUID teacherID : teacherDB.keySet()) if(teacherDB.get(teacherID).getName().equals(name)) return teacherDB.get(teacherID);
        return null;
    }

    public List<String> getListOfStudentsUnderTeacher(String teacher){
        List<String> getList = new ArrayList<>();
        for(Student student : studentTeacherPair.keySet()) if(studentTeacherPair.get(student).getName().equals(teacher)) getList.add(student.getName());
        return getList;
    }
    public void addStudentToTeacher(String student,String teacher){
        UUID getStudentUUID = null, getTeacherUUID = null;
        for(UUID studentID : studentDB.keySet()) if(studentDB.get(studentID).getName().equals(student)) getStudentUUID = studentID;
        for(UUID teacherID : teacherDB.keySet()) if(teacherDB.get(teacherID).getName().equals(teacher)) getTeacherUUID = teacherID;
        
        studentTeacherPair.put(studentDB.get(getStudentUUID),teacherDB.get(getTeacherUUID));
    }
    public void deleteTeacherByName(String teacher){
        for(UUID teacherID : teacherDB.keySet())if(teacherDB.get(teacherID).getName().equals(teacher)) teacherDB.remove(teacherID);
    }
    public void deleteAllTeachers(){
        teacherDB.clear();
        studentDB.clear();
    }
}
