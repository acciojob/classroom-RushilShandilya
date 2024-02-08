package com.driver;

import java.util.UUID;

public class Student {

    //private UUID studentID;
    private String name;
    private int age;
    private double averageScore;

    public Student(/*UUID studentID,*/ String name, int age, double averageScore) {
        //this.studentID = studentID;
        this.name = name;
        this.age = age;
        this.averageScore = averageScore;
    }

    //public UUID getStudentID(){return this.studentID;}
    public String getName(){return this.name;}
    public int getAge(){return this.age;}
    public double getAverageScore(){return this.averageScore;}

    //public void setStudentID(UUID studentID){this.studentID = studentID;}
    public void setName(String name){this.name = name;}
    public void setAge(int age){this.age = age;}
    public void setAverageScore(double averageScore){this.averageScore = averageScore;}
}
