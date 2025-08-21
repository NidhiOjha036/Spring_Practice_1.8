package com.mikadosolutions.training.spring.di;
import java.util.*;
import com.mikadosolutions.training.spring.di.MultiTechnologyTrainer;

public class JavaDotNetTrainer implements MultiTechnologyTrainer{
    String name;
    Set<String> specialties;
    public JavaDotNetTrainer()
    {

    }
    public JavaDotNetTrainer(String name, Set<String> specialties)
    {
        this.name = name;
        this.specialties = specialties;
    }
    public void train(String technology)
    {
        System.out.println(name+" is training on "+technology);
    }
    public void train() throws Exception
    {
        train("Java");
    }
    public void setName(String name)
    {
        this.name = name;
    }
    public String getName()
    {
        return name;
    }
    public void setSpecialties(Set<String> specialties)
    {
        this.specialties = specialties;
    }
    public Set<String> getSpecialties()
    {
        return specialties;
    }
    public String toString()
    {
        return name+" is a Java Trainer";
    }
}
