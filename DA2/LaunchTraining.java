package com.mikado;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;
import com.mikado.Employee;
import java.util.List;

public class LaunchTraining {
    public static void main(String args[]) throws Exception {

        ApplicationContext context = new FileSystemXmlApplicationContext("//Users//nidhi//Desktop//SpringExamples//DA2//TrainingConfig.xml");
        EmployeeDAO dao = (EmployeeDAO)context.getBean("employeedao");
    
        System.out.println("Total No. of Employees by the name Sanjay = "+dao.countOfEmployeesByFirstName("Sanjay"));
        dao.editEmployee(new Employee(1,null,30000));
        

    }
};
