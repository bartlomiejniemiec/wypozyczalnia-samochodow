package com.mv.dao;

import com.mchange.v2.c3p0.ComboPooledDataSource;

import java.net.URI;
import java.net.URISyntaxException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Properties;

public class DBConnectionManager {
    private final ComboPooledDataSource dataSource;

    public DBConnectionManager() {
        setJDBCDriver();

        dataSource = dataSource();
    }

    public Connection getConnection() {
        try {
            return dataSource.getConnection();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    private ComboPooledDataSource dataSource() {
        URI dbUri = getDBUri();
        String userName = dbUri.getUserInfo().split(":")[0];
        String userPassword = dbUri.getUserInfo().split(":")[1];
        Properties properties = new Properties();
        properties.setProperty("user", userName);
        properties.setProperty("password", userPassword);
        properties.setProperty("ssl", "true");
        properties.setProperty("sslfactory", "org.postgresql.ssl.NonValidatingFactory");
        String dbURL = "jdbc:postgresql://" + dbUri.getHost() + ":" + dbUri.getPort() + dbUri.getPath();
        ComboPooledDataSource dataSource = new ComboPooledDataSource();
        dataSource.setJdbcUrl(dbURL);
        dataSource.setProperties(properties);
        dataSource.setMaxPoolSize(10);

        return dataSource;
    }

    private void setJDBCDriver() {
        try {
            Class.forName("org.postgresql.Driver");
        } catch (ClassNotFoundException e) {
            throw new RuntimeException("Wrong JDBC driver path", e);
        }
    }

    private URI getDBUri() {
        try {
            return new URI("postgres://eorxnvqgpozgcf:qZ2DkqE0JUkIZKW611MNAiT6Ne@ec2-54-217-238-100.eu-west-1.compute.amazonaws.com:5432/da1hj9mtmq3d64");
        } catch (URISyntaxException e) {
            throw new RuntimeException("Wrong DB_URI", e);
        }
    }
}