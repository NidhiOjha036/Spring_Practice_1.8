package com.mikado;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;

import com.mikado.Employee;

import java.util.List;

public class LaunchTraining {
    public static void main(String args[]) throws Exception {

        ApplicationContext context = new FileSystemXmlApplicationContext("//Users//nidhi//Desktop//SpringExamples//DA3//TrainingConfig.xml");
        EmployeeDAO dao = (EmployeeDAO)context.getBean("employeedao");
        System.out.println("Total No. of Employees = "+dao.getTotalEmployees());
        System.out.println("Total No. of Employees by the name Sanjay = "+dao.countOfEmployeesByName("Sanjay"));
        System.out.println("Name of the Person with id = 2 is "+dao.getNameForId(2));
        System.out.println("Employee with id 3 = "+dao.getEmployee(3));
        System.out.println("All Employees = "+dao.getAllEmployees());
        System.out.println("All Employees Once Again = "+dao.getAllEmployeesOnceAgain());
        //dao.addEmployee(new Employee(0,"John",10000));
        //dao.editEmployee(new Employee(5,null,20000));
        //dao.deleteEmployee(new Employee(5,null,0));
        

    }
};
