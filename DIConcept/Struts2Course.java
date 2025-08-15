package com.mikadosolutions.training.spring.di;
import java.util.List;

public class Struts2Course implements Course {
    List<String> courseContents;
    int courseDuration;
    double courseFees;

    public Struts2Course() {}

    public Struts2Course(List<String> courseContents, int courseDuration, double courseFees) {
        this.courseContents = courseContents;
        this.courseDuration = courseDuration;
        this.courseFees = courseFees;
    }

    public void setCourseContents(List<String> courseContents) {
        this.courseContents = courseContents;
    }

    public List<String> getCourseContents() {
        return courseContents;
    }

    public void setCourseDuration(int courseDuration) {
        this.courseDuration = courseDuration;
    }

    public int getCourseDuration() {
        return courseDuration;
    }

    public void setCourseFees(double courseFees) {
        this.courseFees = courseFees;
    }

    public double getCourseFees() {
        return courseFees;
    }

    public String toString() {
        return "Struts2 " + courseContents + " duration is " + courseDuration + " Fees is " + courseFees;
    }
}
