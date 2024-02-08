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
    HashMap<Teacher,List<Student>> studentTeacherPair;

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
        Teacher obj = null;

        for(UUID teacherID : teacherDB.keySet()) if(teacherDB.get(teacherID).getName().equals(teacher)) obj = teacherDB.get(teacherID);
        List<Student> list = studentTeacherPair.get(obj);
        List<String> ansList = new ArrayList<>();
        for(Student student : list) ansList.add(student.getName());
        return ansList;
    }
    public void addStudentToTeacher(String student,String teacher){
        Teacher teacherObj = null ;
        Student studentObj = null;

        if(!studentDB.isEmpty())for(UUID studentID : studentDB.keySet()) if(studentDB.get(studentID).getName().equals(student)) studentObj = studentDB.get(studentID);
        if(!teacherDB.isEmpty())for(UUID teacherID : teacherDB.keySet()) if(teacherDB.get(teacherID).getName().equals(teacher)) teacherObj = teacherDB.get(teacherID);

        if(studentTeacherPair.get(teacherObj).isEmpty()) studentTeacherPair.put(teacherObj, new ArrayList<>());

        List<Student> temp = studentTeacherPair.get(teacherObj);
        temp.add(studentObj);
    }
    public void deleteTeacherByName(String teacher){
        UUID getTeacherID = null;
        Teacher teacherObj = null;

        for(UUID teacherID : teacherDB.keySet())
            if(teacherDB.get(teacherID).getName().equals(teacher)){
                getTeacherID = teacherID;
                teacherObj = teacherDB.get(teacherID);
            }

        List<Student> getStudentList = studentTeacherPair.get(teacherObj);
        List<UUID> studentIDS = new ArrayList<>();
        for(Student student : getStudentList) for(UUID studentID : studentDB.keySet()) if(studentDB.get(studentID).getName().equals(student.getName()))studentIDS.add(studentID);
        for(UUID studentId : studentIDS) studentDB.remove(studentId);

        teacherDB.remove(getTeacherID);
        studentTeacherPair.remove(teacherObj);
    }
    public void deleteAllTeachers(){
        studentTeacherPair.clear();
        teacherDB.clear();
        studentDB.clear();
    }
}
