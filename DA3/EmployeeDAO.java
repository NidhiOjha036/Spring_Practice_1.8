package com.mikado;

import org.springframework.jdbc.core.simple.SimpleJdbcTemplate;
import org.springframework.jdbc.core.simple.ParameterizedRowMapper;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.*;

public class EmployeeDAO {

    private SimpleJdbcTemplate simpleJdbcTemplate;
    public void setSimpleJdbcTemplate(SimpleJdbcTemplate simpleJdbcTemplate)
    {
        this.simpleJdbcTemplate = simpleJdbcTemplate;
    }

    //Querying for int
    public int getTotalEmployees()
    {
        int totalEmployees = simpleJdbcTemplate.queryForInt("select count(*) from employee");
        return totalEmployees;
    }

    //Quering for int with placeholder
    public int countOfEmployeesByName(String name)
    {
        int totalEmployees = simpleJdbcTemplate.queryForInt("select count(*) from employee where name=?",new Object[] {name});
        return totalEmployees;
    }

    //Quering for String
    public String getNameForId(int id)
    {
        String name = (String)simpleJdbcTemplate.queryForObject("select name from employee where id=?",String.class,id);
        return name;
    }

    //quering for an object in our case Employee object
    public Employee getEmployee(final int id)
    {
        Employee employee = simpleJdbcTemplate.queryForObject("select name, salary from employee where id = ?", new ParameterizedRowMapper<Employee>()
        {
            public Employee mapRow(ResultSet rs, int rowNum)
            {
                Employee employee = new Employee();
                try
                {
                    System.out.println("Row Number = "+rowNum);
                    employee.setId(id);
                    employee.setName(rs.getString("name"));
                    employee.setSalary(rs.getDouble("salary"));
                }
                catch(SQLException e)
                {
                    System.out.println(e);
                }
                return employee;
            }
        },id);
        return employee;
    }

    //quering for multiple objects in our case Employee objects
    public List<Employee> getAllEmployees()
    {
        List<Employee> employees = simpleJdbcTemplate.query("select * from employee", new ParameterizedRowMapper<Employee>()
        {
            public Employee mapRow(ResultSet rs, int rowNum)
            {
                System.out.println("Row Number = "+rowNum);
                Employee employee = new Employee();
                try
                {
                    employee.setId(rs.getInt(1));
                    employee.setName(rs.getString(2));
                    employee.setSalary(rs.getDouble(3));
                }
                catch(SQLException e)
                {
                    System.out.println(e);
                }
                return employee;
            }
        });
        return employees;
    }

    public List<Employee> getAllEmployeesOnceAgain()
    {
        List<Map<String,Object>> maps = simpleJdbcTemplate.queryForList("Select * from Employee");
        List<Employee> employees = new ArrayList<Employee>();
        for(Map<String,Object>map: maps)
        {
            Employee employee = new Employee();
            employee.setId((Integer)map.get("id"));
            employee.setName((String)map.get("name"));
            employee.setSalary((Double)map.get("salary"));
            employees.add(employee);
        }
        return employees;
    }

    //Firing an insert query
    public void addEmployee(Employee employee)
    {
        int i = simpleJdbcTemplate.update("Insert into employee(name,salary) values(?,?)", employee.getName(), employee.getSalary());
    }

     //Firing an update query
     public void editEmployee(Employee employee)
     {
         int i = simpleJdbcTemplate.update("Update employee set salary = ? where id = ?",employee.getSalary(), employee.getId());
     }

     //Firing a delete query
     public void deleteEmployee(Employee employee)
     {
         int i = simpleJdbcTemplate.update("delete from employee where id = ?",employee.getId());
     }

    

}
