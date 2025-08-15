package com.mikadosolutions.training.spring.di;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;
import com.mikadosolutions.training.spring.di.Employee;

public class LaunchTraining {
    public static void main(String args[]) throws Exception {
        //ApplicationContext context = new FileSystemXmlApplicationContext("//Users//nidhi//Desktop//SpringExamples//DIConcept//TrainingConfig.xml");
        ApplicationContext context = new FileSystemXmlApplicationContext(new String[] {"//Users//nidhi//Desktop//SpringExamples//DIConcept//TrainingConfig.xml","//Users//nidhi//Desktop//SpringExamples//DIConcept//TrainingConfig1.xml"});
        Workshop trainingWorkshop = (Workshop) context.getBean("trainingWorkshop");
        trainingWorkshop.conductWorkshop();
        MyDataSource dataSource = (MyDataSource)context.getBean("myDataSource");
        System.out.println(dataSource.getConnection());
        //Trainer trainer1 = (Trainer)context.getBean("sanjay");
        Trainer trainer1 = (Trainer)context.getBean("praful");
        System.out.println(trainer1.getSpecialties());
    }
};
