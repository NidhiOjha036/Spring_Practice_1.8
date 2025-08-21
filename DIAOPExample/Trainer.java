package com.mikadosolutions.training.spring.di;
import java.util.Set;

public interface Trainer {

    public void train() throws Exception;
    public Set<String> getSpecialties();
    
}