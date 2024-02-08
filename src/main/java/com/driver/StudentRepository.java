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
    public void addStudent(Student student){studentDB.put(UUID.randomUUID(),student);}
    public void addTeacher(Teacher teacher){
        teacherDB.put(UUID.randomUUID(),teacher);
    }

    public List<String> getAllStudent(){
       List<String> listOfStudentName = new ArrayList<>();
       if(!studentDB.isEmpty())for(UUID studentID : studentDB.keySet()) listOfStudentName.add(studentDB.get(studentID).getName());
       return listOfStudentName;
    }
    public Student getStudentDetails(String name){
        if(!studentDB.isEmpty())for(UUID studentID : studentDB.keySet()) if(studentDB.get(studentID).getName().equals(name)) return studentDB.get(studentID);
        return null;
    }
    public Teacher getTeacherDetails(String name){
        if(!teacherDB.isEmpty())for(UUID teacherID : teacherDB.keySet()) if(teacherDB.get(teacherID).getName().equals(name)) return teacherDB.get(teacherID);
        return null;
    }

    public List<String> getListOfStudentsUnderTeacher(String teacher){
        List<String> getList = new ArrayList<>();
        for(Student student : studentTeacherPair.keySet()) if(studentTeacherPair.get(student).getName().equals(teacher)) getList.add(student.getName());
        return getList;
    }
    public void addStudentToTeacher(String student,String teacher){
        UUID getStudentUUID = null, getTeacherUUID = null;
        if(!studentDB.isEmpty())for(UUID studentID : studentDB.keySet()) if(studentDB.get(studentID).getName().equals(student)) getStudentUUID = studentID;
        if(!teacherDB.isEmpty())for(UUID teacherID : teacherDB.keySet()) if(teacherDB.get(teacherID).getName().equals(teacher)) getTeacherUUID = teacherID;
        
        studentTeacherPair.put(studentDB.get(getStudentUUID),teacherDB.get(getTeacherUUID));
    }
    public void deleteTeacherByName(String teacher){
       List<String> studentNames = new ArrayList<>();
       UUID getUUID = null;
       for(Student student : studentTeacherPair.keySet()) if(studentTeacherPair.get(student).getName().equals(teacher)) studentNames.add(student.getName());
       for(String studentName : studentNames) for(UUID studentID : studentDB.keySet()) if(studentDB.get(studentID).getName().equals(studentName))studentDB.remove(studentID);
       for(UUID teacherID : teacherDB.keySet()) if(teacherDB.get(teacherID).getName().equals(teacher)) getUUID = teacherID;
       teacherDB.remove(getUUID);
    }
    public void deleteAllTeachers(){
        studentTeacherPair.clear();
        teacherDB.clear();
        studentDB.clear();
    }
}
