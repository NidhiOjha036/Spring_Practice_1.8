
package com.mikadosolutions.training.spring.di;
import java.util.List;
import org.springframework.beans.factory.BeanNameAware;
import org.springframework.beans.factory.BeanFactoryAware;
import org.springframework.context.ApplicationContextAware;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.DisposableBean;
import org.springframework.context.ApplicationContext;
import org.springframework.beans.factory.BeanFactory;
import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;


//import javax.annotation.PostConstruct;
//import javax.annotation.PreDestroy;

import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;


public class CoreJavaCourse implements Course,BeanNameAware,BeanFactoryAware,ApplicationContextAware,InitializingBean,DisposableBean
{
    List<String> courseContents;
    int courseDuration;
    double courseFees;

    public CoreJavaCourse() { }

    public CoreJavaCourse(List<String> courseContents, int courseDuration, double courseFees) {
        this.courseContents = courseContents;
        this.courseDuration = courseDuration;
        this.courseFees = courseFees;
    }

    public void setCourseContents(List<String> courseContents) {
        this.courseContents = courseContents;
    }

    public void setBeanName(String beanName)
    {
        System.out.println("------Inside setBeanName()-----------"+beanName);
    }

    public void setBeanFactory(BeanFactory beanFactory)
    {
        System.out.println("------Inside setBeanFactory()-----------"+beanFactory);
    }

    public void setApplicationContext(ApplicationContext context)
    {
        System.out.println("------Inside setApplicationContext()-----------"+context);
    }

    public void afterPropertiesSet()
    {
        System.out.println("--------------Inside afterPropertiesSet-----------");
    }

    public void destroy()
    {
        System.out.println("--------------Inside destroy()-----------");
    }

    public void myInit()
    {
        System.out.println("--------------Inside myInit()-----------");
    }

    public void myDestroy()
    {
        System.out.println("--------------Inside myDestroy()-----------");
    }

    @PostConstruct
    public void myInit1()
    {
        System.out.println("--------------Inside myInit1()-----------");
    }

    @PreDestroy
    public void myDestroy1()
    {
        System.out.println("--------------Inside myDestroy1()-----------");
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
        return "Core Java " + courseContents + " duration is " + courseDuration + " Fees is " + courseFees;
    }
}
