package com.mikadosolutions.training.spring.di;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;

public class AdministratorBean implements BeanPostProcessor {

    public Object postProcessBeforeInitialization(Object bean, String beanName)
            throws BeansException {
        System.out.println("About to initialize Bean : " + beanName);
        return bean;
    }

    public Object postProcessAfterInitialization(Object bean, String beanName)
            throws BeansException {
        System.out.println("Initialized Bean : " + beanName);
        
        if (bean instanceof DotNetTrainer) {
            DotNetTrainer dotNettrainer = (DotNetTrainer) bean;
            DotNetTrainerWrapper wrapper = new DotNetTrainerWrapper(dotNettrainer);
            return wrapper;
        } else {
            return bean;
        }
    }
}
