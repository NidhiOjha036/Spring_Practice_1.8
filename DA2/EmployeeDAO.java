package com.mikado;

import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import java.util.*;


public class EmployeeDAO {

    private NamedParameterJdbcTemplate namedParameterJdbcTemplate;
    public void setNamedParameterJdbcTemplate(NamedParameterJdbcTemplate namedParameterJdbcTemplate)
    {
        this.namedParameterJdbcTemplate = namedParameterJdbcTemplate;
    }

    /*
public int countOfEmployeesByFirstName(String name)
{
    String sql = "select count(*) from Employee where name = :name";
    SqlParameterSource namedParameters = new MapSqlParameterSource("name", name);

    // MapSqlParameterSource namedParameters = new MapSqlParameterSource();
    // namedParameters.addValue("salary", 10000);
    // namedParameters.addValue("id", 1);

    // Map map = new Hashtable();
    // map.put("salary", 10000);
    // map.put("id", 1);
    // SqlParameterSource namedParameters = new MapSqlParameterSource(map);

    return namedParameterJdbcTemplate.queryForInt(sql, namedParameters);
}
*/

/*
public int countOfEmployeesByFirstName(String name)
{
    String sql = "select count(*) from Employee where name = :name";
    Map namedParameters = new Hashtable();
    namedParameters.put("name", name);
    return namedParameterJdbcTemplate.queryForInt(sql, namedParameters);
}
*/

public int countOfEmployeesByFirstName(String name)
{
    String sql = "select count(*) from Employee where name = :name";
    SqlParameterSource namedParameters = new BeanPropertySqlParameterSource(new Employee(0, name, 0));
    return namedParameterJdbcTemplate.queryForInt(sql, namedParameters);
}

public void editEmployee(Employee employee)
{
    String sql = "update employee set salary=:salary where id=:id";
    SqlParameterSource namedParameters = new BeanPropertySqlParameterSource(employee);
    namedParameterJdbcTemplate.update(sql, namedParameters);
}
}
