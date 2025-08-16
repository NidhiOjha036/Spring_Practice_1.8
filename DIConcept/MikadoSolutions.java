package com.mikadosolutions.training.spring.di;
import java.util.*;

public class MikadoSolutions implements TrainingCompany {
    
    List<Trainer> trainers;
    static MikadoSolutions mikado;
    Set<Course> courses;
    Map<Course, Trainer> courseTrainers;
    Map<String, Trainer> namesTrainers;

    private MikadoSolutions() {}

    public void setNamesTrainers(Map<String,Trainer> namesTrainers)
    {
        this.namesTrainers = namesTrainers;
        System.out.println("-------------inside setNamesTrainers()--------------"+namesTrainers);
    }

    public static MikadoSolutions getMikadoSolutions() {
        if (mikado == null)
            mikado = new MikadoSolutions();
        return mikado;
    }

    public void conductTraining() {
        Iterator<Trainer> it = trainers.iterator();
        while (it.hasNext()) {
            Trainer trainer = it.next();
            System.out.println(trainer);
            try {
                trainer.train();
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
            
        }
    }

    public void setCourses(Set<Course> courses) {
        this.courses = courses;
        System.out.println("--------------Inside setCourses()---------"+courses);
    }

    public Set<Course> getCourses() {
        return courses;
    }

    public void setCourseTrainers(Map<Course, Trainer> courseTrainers) {
        this.courseTrainers = courseTrainers;
        courses = courseTrainers.keySet();
        Collection<Trainer> values = courseTrainers.values();
        trainers = new ArrayList<Trainer>(values);
    }

    public Map<Course, Trainer> getCourseTrainers() {
        return courseTrainers;
    }

    public void setTrainers(List<Trainer> trainers) {
        this.trainers = trainers;
        System.out.println("--------------Inside setTrainers()---------"+trainers);

    }

    public List<Trainer> getTrainers() {
        return trainers;
    }

    public String toString() {
        return "Mikado Solutions is a Training Company";
    }
};
