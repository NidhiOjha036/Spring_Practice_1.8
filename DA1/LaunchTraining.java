package com.mikado;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;

import com.mikado.Employee;

import java.util.List;

public class LaunchTraining {
    public static void main(String args[]) throws Exception {

        ApplicationContext context = new FileSystemXmlApplicationContext("//Users//nidhi//Desktop//SpringExamples//DA1//TrainingConfig.xml");
        EmployeeDAO dao = (EmployeeDAO)context.getBean("employeedao");
        System.out.println("Total No. of Employees = "+dao.getTotalEmployees());
        System.out.println("Total No. of Employees by the name Sanjay = "+dao.countOfEmployeesByName("Sanjay"));
        System.out.println("Name of the Person with id = 2 is "+dao.getNameForId(2));
        System.out.println("Employee with id 3 = "+dao.getEmployee(3));
        System.out.println("All Employees = "+dao.getAllEmployees());
        //dao.addEmployee(new Employee(0,"Sunil",15000));
        //dao.editEmployee(new Employee(4,null,10000));
        //dao.deleteEmployee(new Employee(4,null,0));
        dao.createTable();

    }
};
