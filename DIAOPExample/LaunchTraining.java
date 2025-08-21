package com.mikadosolutions.training.spring.di;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;
import com.mikadosolutions.training.spring.di.Employee;
import com.mikadosolutions.training.spring.di.MultiTechnologyTrainer;

public class LaunchTraining {
    public static void main(String args[]) throws Exception {
        ApplicationContext context = new FileSystemXmlApplicationContext("//Users//nidhi//Desktop//SpringExamples//DIAOPExample//TrainingConfig.xml");
        Workshop trainingWorkshop = (Workshop) context.getBean("trainingWorkshop");
        trainingWorkshop.conductWorkshop();
        // MultiTechnologyTrainer trainer1 = (MultiTechnologyTrainer)context.getBean("nilesh");
        // trainer1.train("Java");

    
        Trainer newTrainer = (Trainer)context.getBean("sanjay");
        Employee emp = (Employee)newTrainer;
        System.out.println(emp.getSalary());
        newTrainer.train();
    

    }
};
