
package com.mikadosolutions.training.spring.di;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;

public class LaunchTraining {
    public static void main(String args[]) throws Exception {

        //call destroy method()
        AbstractApplicationContext context = new FileSystemXmlApplicationContext("//Users//nidhi//Desktop//SpringExamples//CallBackInterface//TrainingConfig.xml");
        Workshop trainingWorkshop = (Workshop) context.getBean("trainingWorkshop");
        

        // ApplicationContext context = new FileSystemXmlApplicationContext("//Users//nidhi//Desktop//SpringExamples//DIAOPExample//TrainingConfig.xml");
        // Workshop trainingWorkshop = (Workshop) context.getBean("trainingWorkshop");
        
        trainingWorkshop.conductWorkshop();
        context.registerShutdownHook();
    }
};
