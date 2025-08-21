
package com.mikadosolutions.training.spring.di;
import java.util.List;

public class HibernateCourse implements Course {
    List<String> courseContents;
    int courseDuration;
    double courseFees;

    public HibernateCourse() {}

    public HibernateCourse(List<String> courseContents, int courseDuration, double courseFees) {
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
        return "Hibernate " + courseContents + " duration is " + courseDuration + " Fees is " + courseFees;
    }
}
