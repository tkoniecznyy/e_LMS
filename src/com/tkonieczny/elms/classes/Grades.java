package com.tkonieczny.elms.classes;

import java.util.ArrayList;

public class Grades {
    Subjects subject;
    Integer userID;
    Double mark;
    String info;
    String teacher;

    public Grades(Subjects subject, Integer userID, Double mark, String info, String teacher) {
        this.subject = subject;
        this.userID = userID;
        this.mark = mark;
        this.info = info;
        this.teacher = teacher;
    }

    public Subjects getSubject() {
        return subject;
    }

    public void setSubject(Subjects subject) {
        this.subject = subject;
    }

    public Integer getUserID() {
        return userID;
    }

    public void setUserID(Integer userID) {
        this.userID = userID;
    }

    public Double getMark() {
        return mark;
    }

    public void setMark(Double mark) {
        this.mark = mark;
    }

    public String getInfo() {
        return info;
    }

    public void setInfo(String info) {
        this.info = info;
    }

    public String getTeacher() {
        return teacher;
    }

    public void setTeacher(String teacher) {
        this.teacher = teacher;
    }

    public Grades() {
    }

    public static Grades newGrade = new Grades();
    public static ArrayList<Grades> listOfGrades= new ArrayList<>();

    @Override
    public String toString() {
        return getMark() + "                " + subject.toString()+ "                " + getInfo() + "                "+ getTeacher()+ " ";
    }
}
