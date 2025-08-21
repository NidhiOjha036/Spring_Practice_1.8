
package com.mikadosolutions.training.spring.di;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.DeclareParents;

@Aspect
public class Participants
{
    String technology;

    @DeclareParents (value="com.mikadosolutions.training.spring.di.Trainer+", defaultImpl=com.mikadosolutions.training.spring.di.EmployeeImp1.class)
    public static Employee employee;
   
    @Pointcut("execution(* *.train(..))")
    public void xyz()
    {
    }

   @Pointcut("this (com.mikadosolutions.training.spring.di.Trainer)")
    public void abc()
    {
    }

    @Pointcut("execution(* com.mikadosolutions.training.spring.di.MultiTechnologyTrainer.train (java.lang.String) )")
    public void m1()
    {
    }

    //@Pointcut("execution(* com.mikadosolutions.training.spring.di.JavaTrainer.train(..))")
   // @Pointcut("execution(* *.train(..))")
    //@Pointcut("execution(* *.train(..)) && this(com.mikadosolutions.training.spring.di.Trainer)")
    //@Pointcut("execution(* *.train(..)) && this(com.mikadosolutions.training.spring.di.JavaTrainer)")
    //@Pointcut("execution(* *.train(..)) && target(com.mikadosolutions.training.spring.di.JavaTrainer)")
    //@Pointcut("xyz() && abc()")
    //@Pointcut ("execution(* *.train(..)) && bean(sanjay)")
    //@Pointcut("execution(* *.train(..)) && within(com.mikadosolutions.*)")
    //@Pointcut("execution(* *.train(..)) && within(com.mikadosolutions..*)")
    @Pointcut("execution(* com.mikadosolutions.training.spring.di.JavaTrainer.train(..))")
    public void training()
    {
    }
    
    //@Before("training()")
    public void takeSeats()
    {
        System.out.println("Participants please take seats");
    }

   // @Before("training()")
    public void switchOffPhones()
    {
        System.out.println("Participants please switch off phones");
    }

    //@AfterReturning("training()")
    public void applaud()
    {
        System.out.println("Participants CLAP CLAP CLAP");
    }

    //@AfterThrowing("training()")
    public void claimRefund()
    {
        System.out.println("Participants claim Refund");
    }

    @Around("training()")
    public void undergoTraining(ProceedingJoinPoint joinPoint)
    {
        try 
        {
            System.out.println("Participants please take seats");
            System.out.println("Participants please switch off phones");
            long start = System.currentTimeMillis();
            joinPoint.proceed();
            long end = System.currentTimeMillis();
            System.out.println("Participants CLAP CLAP CLAP");
            System.out.println("The Training took "+(end-start)+" milliseconds");
        } 
        catch (Throwable e) 
        {
            System.out.println("Participants Claim Refund");
        }
    }

    @Before("m1() && args(technology)")
    public void predictTraining(String technology)
    {
        System.out.println("Participants are predicting that trainer will train on "+technology);
    }
}