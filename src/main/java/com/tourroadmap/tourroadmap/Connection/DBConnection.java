package com.tourroadmap.tourroadmap.Connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.tourroadmap.tourroadmap.Config.DBConfig;

// import jakarta.annotation.PostConstruct;

@Component
public class DBConnection {
    private static final Logger log = LoggerFactory.getLogger(DBConnection.class);
    public static Connection connection;

    @Autowired
    public Connection getConnection() {
        try {
            // connection = DriverManager.getConnection(datasourceUrl, datasourceUsername,
            // datasour
            connection = DriverManager.getConnection(DBConfig.DB_URL, DBConfig.DB_USERNAME, DBConfig.DB_PASSWORD);
            if (connection == null) {
                throw new SQLException("Connection is null");
            }
            log.info("Connected to PostgreSQL database username :{} ==>> checked by connection service",
                    DBConfig.DB_USERNAME);
            return connection;
        } catch (SQLException e) {
            log.error("Failed to connect to PostgreSQL database: " +
                    e.getMessage());
            return connection;
        }
    }
}
