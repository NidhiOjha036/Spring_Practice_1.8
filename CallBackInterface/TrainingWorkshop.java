
package com.mikadosolutions.training.spring.di;
import java.util.*;
import org.springframework.beans.factory.annotation.Autowired;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Component;

@Component
//@Controller
//@Repository
//@Service
public class TrainingWorkshop implements Workshop{

    //@Autowired
    @Resource(name="mikado")
    TrainingCompany trainingCompany;

    public TrainingWorkshop(){

    }
    public TrainingWorkshop(TrainingCompany trainingCompany){
        this.trainingCompany = trainingCompany;
    }
    public void setTrainingCompany(TrainingCompany trainingCompany){
        this.trainingCompany = trainingCompany;
    }

    public TrainingCompany getTrainingCompany(){
        return trainingCompany;
    }

    public void conductWorkshop(){
        System.out.println(trainingCompany);
        trainingCompany.conductTraining();
    }
}