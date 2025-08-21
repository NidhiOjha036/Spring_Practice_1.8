package com.mikadosolutions.training.spring.di;

import java.util.Set;

public class DotNetTrainer implements Trainer {
    String name;
    Set<String> specialties;

    public DotNetTrainer() {}

    public DotNetTrainer(String name, Set<String> specialties) {
        this.name = name;
        this.specialties = specialties;
    }

    public void train() throws Exception {
        if(Math.random() < 0.5){
            System.out.println(name + " is training on DotNet");
        }else{
            throw new Exception("Training Cancelled");
        }
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setSpecialties(Set<String> specialties) {
        this.specialties = specialties;
    }

    public Set<String> getSpecialties() {
        return specialties;
    }

    public String toString() {
        return name + " is a DotNet Trainer";
    }
}
