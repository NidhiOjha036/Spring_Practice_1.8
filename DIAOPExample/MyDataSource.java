package com.mikadosolutions.training.spring.di;

import java.util.Properties;
import java.sql.*;

public class MyDataSource {
    String driverName, jdbcUrl, username, password;
    Properties properties;
    Connection con;

    public void setProperties(Properties properties) {
        this.properties = properties;
    }

    public Properties getProperties() {
        return properties;
    }

    public void setDriverName(String driverName) {
        this.driverName = driverName;
    }

    public String getDriverName() {
        return driverName;
    }

    public void setJdbcUrl(String jdbcUrl) {
        this.jdbcUrl = jdbcUrl;
    }

    public String getJdbcUrl() {
        return jdbcUrl;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getUsername() {
        return username;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPassword() {
        return password;
    }

    public Connection getConnection() {
        if (properties != null) {
            try {
                Class.forName(properties.getProperty("driverName"));
                con = DriverManager.getConnection(
                    properties.getProperty("jdbcUrl"),
                    properties.getProperty("username"),
                    properties.getProperty("password")
                );
            } catch (Exception e) {
                System.out.println(e);
            }
            return con;
        } else {
            try {
                Class.forName(getDriverName());
                con = DriverManager.getConnection(getJdbcUrl(), getUsername(), getPassword());
            } catch (Exception e) {
                System.out.println(e);
            }
            return con;
        }
    }
}