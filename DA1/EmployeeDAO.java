package com.mikado;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.*;

public class EmployeeDAO {

    private JdbcTemplate jdbcTemplate;
    public void setJdbcTemplate(JdbcTemplate jdbcTemplate)
    {
        this.jdbcTemplate = jdbcTemplate;
    }

    //Querying for int
    public int getTotalEmployees()
    {
        int totalEmployees = jdbcTemplate.queryForInt("select count(*) from employee");
        return totalEmployees;
    }

    //Quering for int with placeholder
    public int countOfEmployeesByName(String name)
    {
        int totalEmployees = jdbcTemplate.queryForInt("select count(*) from employee where name=?",new Object[] {name});
        return totalEmployees;
    }

    //Quering for String
    public String getNameForId(int id)
    {
        String name = (String)jdbcTemplate.queryForObject("select name from employee where id=?",new Object[] {id}, String.class);
        return name;
    }

    //quering for an object in our case Employee object
    public Employee getEmployee(final int id)
    {
        Employee employee = (Employee)jdbcTemplate.queryForObject("select name, salary from employee where id = ?", new Object[] {id}, new RowMapper()
        {
            public Object mapRow(ResultSet rs, int rowNum)
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
        });
        return employee;
    }

    //quering for multiple objects in our case Employee objects
    public List<Employee> getAllEmployees()
    {
        List<Employee> employees = jdbcTemplate.query("select * from employee", new RowMapper()
        {
            public Object mapRow(ResultSet rs, int rowNum)
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

    //Firing an insert query
    public void addEmployee(Employee employee)
    {
        int i = jdbcTemplate.update("Insert into employee(name,salary) values(?,?)",new Object[] {employee.getName(), employee.getSalary()});
    }

     //Firing an update query
     public void editEmployee(Employee employee)
     {
         int i = jdbcTemplate.update("Update employee set salary = ? where id = ?",new Object[] {employee.getSalary(), employee.getId()});
     }

     //Firing a delete query
     public void deleteEmployee(Employee employee)
     {
         int i = jdbcTemplate.update("delete from employee where id = ?",new Object[] {employee.getId()});
     }

     //Firing create table
     public void createTable()
     {
        jdbcTemplate.execute("create table mytable (id int(10) Primary Key AUTO_INCREMENT, name varchar(50))");
     }

}
