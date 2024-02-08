package com.driver;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class Teacher {

    //private UUID teacherID;
    private String name;
    private int numberOfStudents;
    private int age;
    List<Student> listOfStudents;

    public Teacher(/*UUID teacherID ,*/ String name , int numberOfStudents , int age /*List<Student> listOfStudents*/) {
        //this.teacherID = teacherID;
        this.name = name;
        this.numberOfStudents = numberOfStudents;
        this.age = age;
        this.listOfStudents = new ArrayList<>();
    }

    //public void setTeacherID(UUID teacherID) {this.teacherID = teacherID;}
    public void setName(String name) {
        this.name = name;
    }
    public void setNumberOfStudents(int numberOfStudents) {
        this.numberOfStudents = numberOfStudents;
    }
    public void setAge(int age) {
        this.age = age;
    }


    //public UUID getTeacherID(){return this.teacherID;}
    public String getName() {return this.name;}
    public int getNumberOfStudents() {return this.numberOfStudents;}
    public int getAge(){return this.age;}
    public List<Student> getListOfStudents(){return this.listOfStudents;}
}